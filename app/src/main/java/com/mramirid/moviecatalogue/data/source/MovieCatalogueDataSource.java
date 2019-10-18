package com.mramirid.moviecatalogue.data.source;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

public interface MovieCatalogueDataSource {

	LiveData<Resource<PagedList<ItemEntity>>> getMovies(boolean fetchNow);

	LiveData<Resource<PagedList<ItemEntity>>> getTvShows(boolean fetchNow);

	LiveData<Resource<PagedList<ItemEntity>>> getFavoritesPaged(String itemType);

	LiveData<Resource<ItemEntity>> getItem(int itemId);

	void setFavorite(ItemEntity item, boolean newState);
}
