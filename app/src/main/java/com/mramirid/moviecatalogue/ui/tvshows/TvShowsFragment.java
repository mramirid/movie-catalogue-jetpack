package com.mramirid.moviecatalogue.ui.tvshows;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.ui.adapter.ItemsPagedAdapter;
import com.mramirid.moviecatalogue.utils.SpacesItemDecoration;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class TvShowsFragment extends Fragment {

	private RecyclerView rvTvShows;
	private ProgressBar progressBar;
	private TvShowsViewModel tvShowsViewModel;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

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
			tvShowsViewModel = obtainViewModel(getActivity(), this);
			ItemsPagedAdapter tvShowsAdapter = new ItemsPagedAdapter();

			tvShowsViewModel.fetch(false);
			tvShowsViewModel.tvShows.observe(this, pagedListResource -> {
				if (pagedListResource != null) {
					switch (pagedListResource.status) {
						case LOADING:
							rvTvShows.setVisibility(View.GONE);
							progressBar.setVisibility(View.VISIBLE);
							break;
						case SUCCESS:
							rvTvShows.setVisibility(View.VISIBLE);
							progressBar.setVisibility(View.GONE);
							tvShowsAdapter.submitList(pagedListResource.data);
							tvShowsAdapter.notifyDataSetChanged();
							break;
						case ERROR:
							progressBar.setVisibility(View.GONE);
							Toast.makeText(getContext(), pagedListResource.message, Toast.LENGTH_SHORT).show();
							break;
					}
				}
			});

			int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_item_margin);
			rvTvShows.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
			rvTvShows.setLayoutManager(new LinearLayoutManager(getContext()));
			rvTvShows.setHasFixedSize(true);
			rvTvShows.setAdapter(tvShowsAdapter);
		}
	}

	@Override
	public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
		inflater.inflate(R.menu.items_menu, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		if (item.getItemId() == R.id.action_fetch)
			tvShowsViewModel.fetch(true);
		return super.onOptionsItemSelected(item);
	}

	@NonNull
	private TvShowsViewModel obtainViewModel(FragmentActivity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(TvShowsViewModel.class);
	}
}