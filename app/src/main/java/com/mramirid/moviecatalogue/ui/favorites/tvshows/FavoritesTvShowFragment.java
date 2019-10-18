package com.mramirid.moviecatalogue.ui.favorites.tvshows;

import android.os.Bundle;
import android.view.LayoutInflater;
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

public class FavoritesTvShowFragment extends Fragment {

	private RecyclerView rvFavoritesTvShow;
	private ProgressBar progressBar;

	public static FavoritesTvShowFragment newInstance() {
		return new FavoritesTvShowFragment();
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.favorites_fragment, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rvFavoritesTvShow = view.findViewById(R.id.rv_favorites);
		progressBar = view.findViewById(R.id.progress_bar);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() != null) {
			FavoritesTvShowViewModel favoritesTvShowViewModel = obtainViewModel(getActivity(), this);
			ItemsPagedAdapter favoritesTvShowAdapter = new ItemsPagedAdapter();

			favoritesTvShowViewModel.getFavoritesPaged().observe(this, pagedListResource -> {
				if (pagedListResource != null) {
					switch (pagedListResource.status) {
						case LOADING:
							progressBar.setVisibility(View.VISIBLE);
							break;
						case SUCCESS:
							progressBar.setVisibility(View.GONE);
							favoritesTvShowAdapter.submitList(pagedListResource.data);
							favoritesTvShowAdapter.notifyDataSetChanged();
							break;
						case ERROR:
							progressBar.setVisibility(View.GONE);
							Toast.makeText(getContext(), pagedListResource.message, Toast.LENGTH_SHORT).show();
							break;
					}
				}
			});

			int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.rv_item_margin);
			rvFavoritesTvShow.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
			rvFavoritesTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
			rvFavoritesTvShow.setHasFixedSize(true);
			rvFavoritesTvShow.setAdapter(favoritesTvShowAdapter);
		}
	}

	private FavoritesTvShowViewModel obtainViewModel(FragmentActivity activity, Fragment fragment) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(fragment, factory).get(FavoritesTvShowViewModel.class);
	}
}
