package com.mramirid.moviecatalogue.ui.favorites.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;

public class FavoritesMovieViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public FavoritesMovieViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<Resource<PagedList<ItemEntity>>> getFavoritesPaged() {
		return movieCatalogueRepository.getFavoritesPaged(TYPE_MOVIE);
	}

	void setFavorite(ItemEntity movie) {
		final boolean newState = !movie.isFavorited();
		movieCatalogueRepository.setFavorite(movie, newState);
	}
}
