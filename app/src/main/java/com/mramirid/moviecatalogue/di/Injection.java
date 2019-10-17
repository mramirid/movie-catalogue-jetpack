package com.mramirid.moviecatalogue.di;

import android.app.Application;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.LocalRepository;
import com.mramirid.moviecatalogue.data.source.local.room.MovieCatalogueDatabase;
import com.mramirid.moviecatalogue.data.source.remote.RemoteRepository;
import com.mramirid.moviecatalogue.utils.JsonHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Injection {

	public static MovieCatalogueRepository provideRepository(Application application) {
		MovieCatalogueDatabase database = MovieCatalogueDatabase.getInstance(application);

		LocalRepository localRepository = LocalRepository.getInstance(database.movieCatalogueDao());
		RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper());
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		return MovieCatalogueRepository.getInstance(remoteRepository, localRepository, executorService);
	}
}
