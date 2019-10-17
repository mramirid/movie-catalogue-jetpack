package com.mramirid.moviecatalogue.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.di.Injection;
import com.mramirid.moviecatalogue.ui.detail.DetailItemViewModel;
import com.mramirid.moviecatalogue.ui.favorites.movies.FavoritesMovieViewModel;
import com.mramirid.moviecatalogue.ui.favorites.tvshows.FavoritesTvShowViewModel;
import com.mramirid.moviecatalogue.ui.movies.MoviesViewModel;
import com.mramirid.moviecatalogue.ui.tvshows.TvShowsViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

	private static volatile ViewModelFactory INSTANCE;

	private final MovieCatalogueRepository movieCatalogueRepository;

	private ViewModelFactory(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	public static ViewModelFactory getInstance(Application application) {
		if (INSTANCE == null) {
			synchronized (ViewModelFactory.class) {
				if (INSTANCE == null)
					INSTANCE = new ViewModelFactory(Injection.provideRepository(application));
			}
		}
		return INSTANCE;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
		if (modelClass.isAssignableFrom(DetailItemViewModel.class)) {
			//noinspection unchecked
			return (T) new DetailItemViewModel(movieCatalogueRepository);
		} else if (modelClass.isAssignableFrom(MoviesViewModel.class)) {
			//noinspection unchecked
			return (T) new MoviesViewModel(movieCatalogueRepository);
		} else if (modelClass.isAssignableFrom(TvShowsViewModel.class)) {
			//noinspection unchecked
			return (T) new TvShowsViewModel(movieCatalogueRepository);
		} else if (modelClass.isAssignableFrom(FavoritesMovieViewModel.class)) {
			//noinspection unchecked
			return (T) new FavoritesMovieViewModel(movieCatalogueRepository);
		} else if (modelClass.isAssignableFrom(FavoritesTvShowViewModel.class)) {
			//noinspection unchecked
			return (T) new FavoritesTvShowViewModel(movieCatalogueRepository);
		}

		throw new IllegalArgumentException("Unknown ViewModel class named " + modelClass.getName());
	}
}
