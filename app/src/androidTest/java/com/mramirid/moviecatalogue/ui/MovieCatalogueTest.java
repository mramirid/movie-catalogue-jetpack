package com.mramirid.moviecatalogue.ui;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.home.HomeActivity;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;
import com.mramirid.moviecatalogue.utils.RecyclerViewItemCountAssertion;
import com.mramirid.moviecatalogue.utils.TabLayoutViewAction;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MovieCatalogueTest {

	@Rule
	public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@Test
	public void toDetailMovieActivity() {
		// Clear database favorites movie untuk skenario testing selanjutnya
		onView(withId(R.id.navigation_favorites)).perform(click());
		onView(withId(R.id.tab_layout)).perform(new TabLayoutViewAction(0));
		onView(withId(R.id.action_clear)).perform(click());

		onView(withId(R.id.navigation_movies)).perform(click());
		onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
		onView(withId(R.id.rv_movies)).check(new RecyclerViewItemCountAssertion(20));
		onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

		onView(withId(R.id.img_cover)).check(matches(isDisplayed()));
		onView(withId(R.id.img_photo)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_language)).perform(scrollTo());
		onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
		onView(withId(R.id.rb_star)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_genres)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_year)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_description)).perform(scrollTo());
		onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
	}

	@Test
	public void toDetailTvShowActivity() {
		// Clear database favorites tv show untuk skenario testing selanjutnya
		onView(withId(R.id.navigation_favorites)).perform(click());
		onView(withId(R.id.tab_layout)).perform(new TabLayoutViewAction(1));
		onView(withId(R.id.action_clear)).perform(click());

		onView(withId(R.id.navigation_tv_shows)).perform(click());
		onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
		onView(withId(R.id.rv_tv_shows)).check(new RecyclerViewItemCountAssertion(20));
		onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

		onView(withId(R.id.img_cover)).check(matches(isDisplayed()));
		onView(withId(R.id.img_photo)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_language)).perform(scrollTo());
		onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
		onView(withId(R.id.rb_star)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_genres)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_year)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_language)).check(matches(isDisplayed()));
		onView(withId(R.id.tv_description)).perform(scrollTo());
		onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
	}
}
