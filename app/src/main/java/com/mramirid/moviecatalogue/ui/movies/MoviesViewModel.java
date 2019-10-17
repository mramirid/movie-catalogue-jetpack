package com.mramirid.moviecatalogue.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

import java.util.ArrayList;

public class MoviesViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public MoviesViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<ArrayList<ItemEntity>> getMovies() {
		return movieCatalogueRepository.getMovies();
	}
}