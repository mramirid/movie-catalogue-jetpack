package com.mramirid.moviecatalogue.ui.movies;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MoviesViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private MoviesViewModel viewModel;
	private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

	@Before
	public void setUp() {
		viewModel = new MoviesViewModel(movieCatalogueRepository);
	}

	@Test
	public void getMovies() {
		ArrayList<ItemEntity> dummyMovies = FakeDataDummy.getDummyMovies();
		MutableLiveData<ArrayList<ItemEntity>> movies = new MutableLiveData<>();
		movies.setValue(dummyMovies);
		when(movieCatalogueRepository.getMovies()).thenReturn(movies);

		Observer<ArrayList<ItemEntity>> observer = mock(Observer.class);
		viewModel.getMovies().observeForever(observer);
		verify(observer).onChanged(dummyMovies);

		ArrayList<ItemEntity> movieResults = viewModel.getMovies().getValue();
		assertNotNull(movieResults);
		assertEquals(10, movieResults.size());
	}
}