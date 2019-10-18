package com.mramirid.moviecatalogue.ui.favorites.tvshows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class FavoritesTvShowViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	public FavoritesTvShowViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<Resource<PagedList<ItemEntity>>> getFavoritesPaged() {
		return movieCatalogueRepository.getFavoritesPaged(TYPE_TV_SHOW);
	}

	void setFavorite(ItemEntity tvShow) {
		final boolean newState = !tvShow.isFavorited();
		movieCatalogueRepository.setFavorite(tvShow, newState);
	}
}
