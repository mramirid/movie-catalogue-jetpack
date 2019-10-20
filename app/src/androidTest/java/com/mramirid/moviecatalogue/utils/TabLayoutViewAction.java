package com.mramirid.moviecatalogue.utils;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import com.google.android.material.tabs.TabLayout;

import org.hamcrest.Matcher;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

public class TabLayoutViewAction implements ViewAction {

	private final int tabIndex;

	public TabLayoutViewAction(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	@Override
	public Matcher<View> getConstraints() {
		return allOf(isDisplayed(), isAssignableFrom(TabLayout.class));
	}

	@Override
	public String getDescription() {
		return "with tab at index " + tabIndex;
	}

	@Override
	public void perform(UiController uiController, View view) {
		if (view instanceof TabLayout) {
			TabLayout tabLayout = (TabLayout) view;
			TabLayout.Tab tab = tabLayout.getTabAt(tabIndex);
			if (tab != null)
				tab.select();
		}
	}
}
