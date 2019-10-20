package com.mramirid.moviecatalogue.ui.movies;

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

public class MoviesFragment extends Fragment {

	private RecyclerView rvMovies;
	private ProgressBar progressBar;
	private MoviesViewModel moviesViewModel;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

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
			moviesViewModel = obtainViewModel(getActivity(), this);
			ItemsPagedAdapter moviesAdapter = new ItemsPagedAdapter();

			moviesViewModel.fetch(false);
			moviesViewModel.movies.observe(this, pagedListResource -> {
				if (pagedListResource != null) {
					switch (pagedListResource.status) {
						case LOADING:
							rvMovies.setVisibility(View.GONE);
							progressBar.setVisibility(View.VISIBLE);
							break;
						case SUCCESS:
							rvMovies.setVisibility(View.VISIBLE);
							progressBar.setVisibility(View.GONE);
							moviesAdapter.submitList(pagedListResource.data);
							moviesAdapter.notifyDataSetChanged();
							break;
						case ERROR:
							progressBar.setVisibility(View.GONE);
							Toast.makeText(getContext(), pagedListResource.message, Toast.LENGTH_SHORT).show();
							break;
					}
				}
			});

			int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_item_margin);
			rvMovies.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
			rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
			rvMovies.setHasFixedSize(true);
			rvMovies.setAdapter(moviesAdapter);
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
			moviesViewModel.fetch(true);
		return super.onOptionsItemSelected(item);
	}

	@NonNull
	private MoviesViewModel obtainViewModel(FragmentActivity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(MoviesViewModel.class);
	}
}