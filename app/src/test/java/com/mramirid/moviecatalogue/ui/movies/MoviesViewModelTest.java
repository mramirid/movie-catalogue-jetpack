package com.mramirid.moviecatalogue.ui.movies;

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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private MoviesViewModel moviesViewModel;
	private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

	@Before
	public void setUp() {
		moviesViewModel = new MoviesViewModel(movieCatalogueRepository);
	}

	@Test
	public void getMovies() {
		MutableLiveData<Resource<PagedList<ItemEntity>>> dummyMovies = new MutableLiveData<>();

		//noinspection unchecked
		PagedList<ItemEntity> pagedList = mock(PagedList.class);

		dummyMovies.setValue(Resource.success(pagedList));

		when(movieCatalogueRepository.getMovies(false)).thenReturn(dummyMovies);

		//noinspection unchecked
		Observer<Resource<PagedList<ItemEntity>>> observer = mock(Observer.class);

		moviesViewModel.fetch(false);
		moviesViewModel.movies.observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));
	}
}