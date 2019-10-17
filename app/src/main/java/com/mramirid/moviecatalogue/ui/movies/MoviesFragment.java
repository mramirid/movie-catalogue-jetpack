package com.mramirid.moviecatalogue.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.adapter.ItemsAdapter;
import com.mramirid.moviecatalogue.utils.SpacesItemDecoration;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class MoviesFragment extends Fragment {

	private RecyclerView rvMovies;
	private ProgressBar progressBar;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_movies, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rvMovies = view.findViewById(R.id.rv_movies);
		progressBar = view.findViewById(R.id.progress_bar);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() != null) {
			MoviesViewModel viewModel = obtainViewModel(getActivity(), this);
			ItemsAdapter moviesAdapter = new ItemsAdapter(getActivity());
			progressBar.setVisibility(View.VISIBLE);

			viewModel.getMovies().observe(this, itemEntities -> {
				progressBar.setVisibility(View.GONE);
				moviesAdapter.setItems(itemEntities);
				moviesAdapter.notifyDataSetChanged();
			});

			int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_item_margin);
			rvMovies.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
			rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
			rvMovies.setHasFixedSize(true);
			rvMovies.setAdapter(moviesAdapter);
		}
	}

	@NonNull
	private MoviesViewModel obtainViewModel(FragmentActivity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(MoviesViewModel.class);
	}
}