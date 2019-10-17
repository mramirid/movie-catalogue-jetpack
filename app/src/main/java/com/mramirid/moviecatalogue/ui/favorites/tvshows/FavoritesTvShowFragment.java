package com.mramirid.moviecatalogue.ui.favorites.tvshows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class FavoritesTvShowFragment extends Fragment {

	private FavoritesTvShowViewModel viewModel;

	public static FavoritesTvShowFragment newInstance() {
		return new FavoritesTvShowFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.favorites_tv_show_fragment, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() != null) {
			viewModel = obtainViewModel(getActivity(), this);
		}
		// TODO: Use the ViewModel
	}

	private FavoritesTvShowViewModel obtainViewModel(FragmentActivity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(FavoritesTvShowViewModel.class);
	}
}
