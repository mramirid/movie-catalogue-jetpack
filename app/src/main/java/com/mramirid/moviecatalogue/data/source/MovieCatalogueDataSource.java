package com.mramirid.moviecatalogue.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

import java.util.ArrayList;

public interface MovieCatalogueDataSource {
	LiveData<ArrayList<ItemEntity>> getMovies();
	LiveData<ArrayList<ItemEntity>> getTvShows();
	LiveData<ItemEntity> getItem(String itemType, int id);
	void insertFavorite(ItemEntity item);
	void deleteFavorite(ItemEntity item);
	LiveData<PagedList<ItemEntity>> getFavoritesPaged(String itemType);
}
