package com.mramirid.moviecatalogue.ui.favorites.movies;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.testing.SingleFragmentActivity;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FavoritesMovieFragmentTest {

	@Rule
	public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);

	private FavoritesMovieFragment favoritesMovieFragment = new FavoritesMovieFragment();

	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
		activityRule.getActivity().setFragment(favoritesMovieFragment);
	}

	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@Test
	public void loadFavoritesMovie() {
		onView(withId(R.id.tv_favorites_empty)).check(matches(isDisplayed()));

//		onView(withId(R.id.rv_favorites)).check(matches(isDisplayed()));
//		onView(withId(R.id.rv_favorites)).check(new RecyclerViewItemCountAssertion(1));
	}
}