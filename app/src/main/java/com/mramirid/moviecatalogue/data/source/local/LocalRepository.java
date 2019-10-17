package com.mramirid.moviecatalogue.data.source.local;

import androidx.paging.DataSource;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.local.room.MovieCatalogueDao;

public class LocalRepository {

	private final MovieCatalogueDao movieCatalogueDao;

	private static LocalRepository INSTANCE;

	private LocalRepository(MovieCatalogueDao movieCatalogueDao) {
		this.movieCatalogueDao = movieCatalogueDao;
	}

	public static LocalRepository getInstance(MovieCatalogueDao movieCatalogueDao) {
		if (INSTANCE == null)
			INSTANCE = new LocalRepository(movieCatalogueDao);
		return INSTANCE;
	}

	public DataSource.Factory<Integer, ItemEntity> getFavoritesPaged(String itemType) {
		return movieCatalogueDao.getFavoritesAsPaged(itemType);
	}

	public void insertFavorite(ItemEntity item) {
		movieCatalogueDao.insertFavorite(item);
	}

	public void deleteFavorite(ItemEntity item) {
		movieCatalogueDao.deleteFavorite(item);
	}
}
