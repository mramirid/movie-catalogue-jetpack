package com.mramirid.moviecatalogue.ui.favorites.tvshows;

import androidx.lifecycle.ViewModel;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;

public class FavoritesTvShowViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public FavoritesTvShowViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}
	// TODO: Implement the ViewModel
}
