package com.mramirid.moviecatalogue.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	private final List<Fragment> pageFragments = new ArrayList<>();
	private final List<String> pageTitles = new ArrayList<>();

	public ViewPagerAdapter(@NonNull FragmentManager fm) {
		super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
	}

	public void addFragment(Fragment pageFragment, String pageTitle) {
		pageFragments.add(pageFragment);
		pageTitles.add(pageTitle);
	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		return pageFragments.get(position);
	}

	@Override
	public int getCount() {
		return pageFragments.size();
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return pageTitles.get(position);
	}
}
