package com.mramirid.moviecatalogue.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

import java.util.List;

@Dao
public interface MovieCatalogueDao {

	@WorkerThread
	@Query("SELECT * FROM itemEntities WHERE itemType = :itemType")
	DataSource.Factory<Integer, ItemEntity> getItems(String itemType);

	@WorkerThread
	@Query("SELECT * FROM itemEntities WHERE favorited = 1 AND itemType = :itemType")
	DataSource.Factory<Integer, ItemEntity> getFavoritedItemsAsPaged(String itemType);

	@Query("SELECT * FROM itemEntities WHERE id = :itemId")
	LiveData<ItemEntity> getItem(int itemId);

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insertItems(List<ItemEntity> items);

	@Update()
	void updateItem(ItemEntity item);

	@Query("DELETE FROM itemEntities WHERE itemType = :itemType AND favorited = 0")
	void clearNonFavoritesItemByType(String itemType);
}
