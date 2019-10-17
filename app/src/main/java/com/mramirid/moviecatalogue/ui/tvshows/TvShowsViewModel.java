package com.mramirid.moviecatalogue.ui.tvshows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

import java.util.ArrayList;

public class TvShowsViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public TvShowsViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<ArrayList<ItemEntity>> getTvShows() {
		return movieCatalogueRepository.getTvShows();
	}
}