package com.mramirid.moviecatalogue.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.adapter.ViewPagerAdapter;
import com.mramirid.moviecatalogue.ui.favorites.movies.FavoritesMovieFragment;
import com.mramirid.moviecatalogue.ui.favorites.tvshows.FavoritesTvShowFragment;

public class FavoritesFragment extends Fragment {

	public FavoritesFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.parent_favorites_fragment, container, false);

		TabLayout tabLayout = view.findViewById(R.id.tab_layout);
		ViewPager viewPager = view.findViewById(R.id.viewpager);

		if (getFragmentManager() != null) {
			ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
			viewPagerAdapter.addFragment(FavoritesMovieFragment.newInstance(), getString(R.string.movies));
			viewPagerAdapter.addFragment(FavoritesTvShowFragment.newInstance(), getString(R.string.tv_shows));
			viewPager.setAdapter(viewPagerAdapter);
			viewPager.setOffscreenPageLimit(2);
			tabLayout.setupWithViewPager(viewPager);
		}

		return view;
	}
}
