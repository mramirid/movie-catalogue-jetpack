package com.mramirid.moviecatalogue.ui.tvshows;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.adapter.ItemsAdapter;
import com.mramirid.moviecatalogue.utils.SpacesItemDecoration;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class TvShowsFragment extends Fragment {

	private RecyclerView rvTvShows;
	private ProgressBar progressBar;

	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_tv_shows, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rvTvShows = view.findViewById(R.id.rv_tv_shows);
		progressBar = view.findViewById(R.id.progress_bar);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() != null) {
			TvShowsViewModel viewModel = obtainViewModel(getActivity(), this);
			ItemsAdapter tvShowsAdapter = new ItemsAdapter(getActivity());
			progressBar.setVisibility(View.VISIBLE);

			viewModel.getTvShows().observe(this, itemEntities -> {
				progressBar.setVisibility(View.GONE);
				tvShowsAdapter.setItems(itemEntities);
				tvShowsAdapter.notifyDataSetChanged();
			});

			int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_item_margin);
			rvTvShows.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
			rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
			rvTvShows.setHasFixedSize(true);
			rvTvShows.setAdapter(tvShowsAdapter);
		}
	}

	private TvShowsViewModel obtainViewModel(Activity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(TvShowsViewModel.class);
	}
}