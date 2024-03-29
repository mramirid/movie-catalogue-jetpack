package com.mramirid.moviecatalogue.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.local.room.MovieCatalogueDao;

import java.util.List;

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

	public DataSource.Factory<Integer, ItemEntity> getItemsPaged(String itemType) {
		return movieCatalogueDao.getItemsAsPaged(itemType);
	}

	public DataSource.Factory<Integer, ItemEntity> getFavoritesItemPaged(String itemType) {
		return movieCatalogueDao.getFavoritesItemAsPaged(itemType);
	}

	public LiveData<ItemEntity> getItem(int itemId) {
		return movieCatalogueDao.getItem(itemId);
	}

	public void insertItems(List<ItemEntity> items) {
		movieCatalogueDao.insertItems(items);
	}

	public void setFavorite(ItemEntity item, boolean newState) {
		item.setFavorited(newState);
		movieCatalogueDao.updateItem(item);
	}

	public void clearNonFavoritesItemByType(String itemType) {
		movieCatalogueDao.clearNonFavoritesItemByType(itemType);
	}

	public void clearFavorites(String itemType) {
		movieCatalogueDao.clearFavoritesItemByType(itemType);
	}
}
