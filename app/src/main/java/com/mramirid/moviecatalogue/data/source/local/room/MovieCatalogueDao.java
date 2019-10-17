package com.mramirid.moviecatalogue.data.source.local.room;

import androidx.annotation.WorkerThread;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

@Dao
public interface MovieCatalogueDao {

	@WorkerThread
	@Query("SELECT * FROM itemEntities WHERE itemType = :itemType")
	DataSource.Factory<Integer, ItemEntity> getFavoritesAsPaged(String itemType);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertFavorite(ItemEntity item);

	@Delete
	void deleteFavorite(ItemEntity item);
}
