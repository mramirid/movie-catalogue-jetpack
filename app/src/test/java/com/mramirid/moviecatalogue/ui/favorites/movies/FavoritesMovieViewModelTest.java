package com.mramirid.moviecatalogue.ui.favorites.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoritesMovieViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private FavoritesMovieViewModel favoritesMovieViewModel;
	private MovieCatalogueRepository movieCatalogueRepository;

	@Before
	public void setUp() {
		movieCatalogueRepository = mock(MovieCatalogueRepository.class);
		favoritesMovieViewModel = new FavoritesMovieViewModel(movieCatalogueRepository);
	}

	@Test
	public void getFavoritesMovie() {
		MutableLiveData<Resource<PagedList<ItemEntity>>> dummyFavoritesMovie = new MutableLiveData<>();

		//noinspection unchecked
		PagedList<ItemEntity> pagedList = mock(PagedList.class);

		dummyFavoritesMovie.setValue(Resource.success(pagedList));

		when(movieCatalogueRepository.getFavoritesPaged(TYPE_MOVIE)).thenReturn(dummyFavoritesMovie);

		//noinspection unchecked
		Observer<Resource<PagedList<ItemEntity>>> observer = mock(Observer.class);

		favoritesMovieViewModel.getFavoritesPaged().observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));
	}
}