package com.mramirid.moviecatalogue.di;

import android.app.Application;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.LocalRepository;
import com.mramirid.moviecatalogue.data.source.local.room.MovieCatalogueDatabase;
import com.mramirid.moviecatalogue.data.source.remote.RemoteRepository;
import com.mramirid.moviecatalogue.utils.AppExecutors;
import com.mramirid.moviecatalogue.utils.JsonHelper;

public class Injection {

	public static MovieCatalogueRepository provideRepository(Application application) {
		MovieCatalogueDatabase database = MovieCatalogueDatabase.getInstance(application);

		LocalRepository localRepository = LocalRepository.getInstance(database.movieCatalogueDao());
		RemoteRepository remoteRepository = RemoteRepository.getInstance(new JsonHelper());
		AppExecutors appExecutors = new AppExecutors();

		return MovieCatalogueRepository.getInstance(remoteRepository, localRepository, appExecutors);
	}
}
