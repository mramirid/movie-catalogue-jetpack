package com.mramirid.moviecatalogue.ui.detail;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;
import com.mramirid.moviecatalogue.utils.FakeDataDummy;
import com.mramirid.moviecatalogue.utils.RatingBarValueAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailMovieActivityTest {

	private ItemEntity dummyMovie = FakeDataDummy.getDummyMovie();

	@Rule
	public ActivityTestRule<DetailItemActivity> activityRule = new ActivityTestRule<DetailItemActivity>(DetailItemActivity.class) {
		@Override
		protected Intent getActivityIntent() {
			Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
			Intent result = new Intent(targetContext, DetailItemActivity.class);
			result.putExtra(DetailItemActivity.EXTRA_ITEM_ID, dummyMovie.getId());
			return result;
		}
	};

	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@Test
	public void loadMovie() {
		onView(withId(R.id.img_photo)).check(matches(isDisplayed()));

		onView(withId(R.id.tv_language)).perform(scrollTo());
		onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_name)).check(matches(withText(dummyMovie.getName())));

		onView(withId(R.id.rb_star)).check(matches(isDisplayed()));
		onView(withId(R.id.rb_star)).check(new RatingBarValueAssertion(dummyMovie.getRating()));

		onView(withId(R.id.tv_genres)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_genres)).check(matches(withText(dummyMovie.getGenres())));

		onView(withId(R.id.tv_year)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_year)).check(matches(withText(String.valueOf(dummyMovie.getYear()))));

		onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_language)).check(matches(withText(dummyMovie.getLanguage())));

		onView(withId(R.id.tv_description)).perform(scrollTo());
		onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_description)).check(matches(withText(dummyMovie.getDescription())));
	}
}