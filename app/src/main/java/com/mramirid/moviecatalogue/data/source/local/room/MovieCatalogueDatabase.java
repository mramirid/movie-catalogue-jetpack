package com.mramirid.moviecatalogue.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

@Database(entities = {ItemEntity.class}, version = 1, exportSchema = false)
public abstract class MovieCatalogueDatabase extends RoomDatabase {

	private static MovieCatalogueDatabase INSTANCE;

	public abstract MovieCatalogueDao movieCatalogueDao();

	private static final Object lock = new Object();

	public static MovieCatalogueDatabase getInstance(Context context) {
		synchronized (lock) {
			if (INSTANCE == null) {
				INSTANCE = Room.databaseBuilder(
						context.getApplicationContext(),
						MovieCatalogueDatabase.class,
						"MovieCatalogue.db"
				).build();
			}
			return INSTANCE;
		}
	}
}
