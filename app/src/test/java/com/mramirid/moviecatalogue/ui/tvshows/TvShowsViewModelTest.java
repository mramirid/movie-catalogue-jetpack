package com.mramirid.moviecatalogue.ui.tvshows;

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

public class TvShowsViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private TvShowsViewModel viewModel;
	private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

	@Before
	public void setUp() {
		viewModel = new TvShowsViewModel(movieCatalogueRepository);
	}

	@Test
	public void getTvShows() {
		ArrayList<ItemEntity> dummyTvShows = FakeDataDummy.getDummyTvShows();
		MutableLiveData<ArrayList<ItemEntity>> tvShows = new MutableLiveData<>();
		tvShows.setValue(dummyTvShows);
		when(movieCatalogueRepository.getTvShows()).thenReturn(tvShows);

		Observer<ArrayList<ItemEntity>> observer = mock(Observer.class);
		viewModel.getTvShows().observeForever(observer);
		verify(observer).onChanged(dummyTvShows);

		ArrayList<ItemEntity> movieResults = viewModel.getTvShows().getValue();
		assertNotNull(movieResults);
		assertEquals(10, movieResults.size());
	}
}