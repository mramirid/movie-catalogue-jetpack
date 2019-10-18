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
	long[] insertItems(List<ItemEntity> items);

	@Update()
	int updateItem(ItemEntity item);
}
