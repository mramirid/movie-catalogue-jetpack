package com.mramirid.moviecatalogue.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

public class MoviesViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public MoviesViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<Resource<PagedList<ItemEntity>>> getMovies(boolean reFetch) {
		return movieCatalogueRepository.getMovies(reFetch);
	}
}