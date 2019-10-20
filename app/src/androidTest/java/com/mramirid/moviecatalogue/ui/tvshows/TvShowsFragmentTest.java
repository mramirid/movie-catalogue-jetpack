package com.mramirid.moviecatalogue.ui.tvshows;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.testing.SingleFragmentActivity;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;
import com.mramirid.moviecatalogue.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TvShowsFragmentTest {

	@Rule
	public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);

	private TvShowsFragment tvShowsFragment = new TvShowsFragment();

	@Before
	public void setUp() {
		IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
		activityRule.getActivity().setFragment(tvShowsFragment);
	}

	@After
	public void tearDown() {
		IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
	}

	@Test
	public void	loadTvShows() {
		try {
			// Terlalu cepat, testing gagal
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
		onView(withId(R.id.rv_tv_shows)).check(new RecyclerViewItemCountAssertion(20));
	}
}