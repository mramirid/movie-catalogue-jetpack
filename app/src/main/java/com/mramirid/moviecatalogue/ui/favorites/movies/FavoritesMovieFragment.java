package com.mramirid.moviecatalogue.ui.favorites.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.favorites.FavoritesFragment;

public class FavoritesMovieFragment extends Fragment {

	private FavoritesMovieViewModel viewModel;
	private static FavoritesFragment INSTANCE;

	public static FavoritesMovieFragment newInstance() {
		return new FavoritesMovieFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.favorites_movie_fragment, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		viewModel = ViewModelProviders.of(this).get(FavoritesMovieViewModel.class);
		// TODO: Use the ViewModel
	}

}
