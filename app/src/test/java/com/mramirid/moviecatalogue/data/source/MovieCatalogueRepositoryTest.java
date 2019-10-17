package com.mramirid.moviecatalogue.data.source;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.remote.RemoteRepository;
import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;
import com.mramirid.moviecatalogue.utils.FakeDataDummy;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MovieCatalogueRepositoryTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private RemoteRepository remote = mock(RemoteRepository.class);
	private FakeMovieCatalogueRepository movieCatalogueRepository = new FakeMovieCatalogueRepository(remote);

	private ArrayList<ItemResponse> movieResponses = FakeDataDummy.getRemoteDummyMovies();
	private ArrayList<ItemResponse> tvShowResponses = FakeDataDummy.getRemoteDummyTvShows();
	private int movieId = movieResponses.get(0).getId();
	private int tvShowId = tvShowResponses.get(0).getId();

	@Test
	public void getMovies() {
		doAnswer(invocation -> {
			((RemoteRepository.LoadItemsCallback) invocation.getArguments()[0])
					.onItemsReceived(movieResponses);
			return null;
		}).when(remote).getMovies(any(RemoteRepository.LoadItemsCallback.class));

		ArrayList<ItemEntity> movieResult = movieCatalogueRepository.getMovies().getValue();

		verify(remote, times(1)).getMovies(any(RemoteRepository.LoadItemsCallback.class));

		assertNotNull(movieResult);
		assertEquals(movieResponses.size(), movieResult.size());
	}

	@Test
	public void getTvShows() {
		doAnswer(invocation -> {
			((RemoteRepository.LoadItemsCallback) invocation.getArguments()[0])
					.onItemsReceived(tvShowResponses);
			return null;
		}).when(remote).getTvShows(any(RemoteRepository.LoadItemsCallback.class));

		ArrayList<ItemEntity> tvShowResult = movieCatalogueRepository.getTvShows().getValue();

		verify(remote, times(1)).getTvShows(any(RemoteRepository.LoadItemsCallback.class));

		assertNotNull(tvShowResult);
		assertEquals(tvShowResponses.size(), tvShowResult.size());
	}

	@SuppressWarnings("ConstantConditions")
	@Test
	public void getItem() {
		doAnswer(invocation -> {
			((RemoteRepository.LoadItemsCallback) invocation.getArguments()[0])
					.onItemsReceived(movieResponses);
			return null;
		}).when(remote).getMovies(any(RemoteRepository.LoadItemsCallback.class));

		doAnswer(invocation -> {
			((RemoteRepository.LoadItemsCallback) invocation.getArguments()[0])
					.onItemsReceived(tvShowResponses);
			return null;
		}).when(remote).getTvShows(any(RemoteRepository.LoadItemsCallback.class));

		ItemEntity movieResult = movieCatalogueRepository.getMovies().getValue().get(0);
		ItemEntity tvShowResult = movieCatalogueRepository.getTvShows().getValue().get(0);

		verify(remote, times(1)).getMovies(any(RemoteRepository.LoadItemsCallback.class));
		verify(remote, times(1)).getTvShows(any(RemoteRepository.LoadItemsCallback.class));

		assertNotNull(movieResult);
		assertNotNull(tvShowResult);
		assertEquals(movieId, movieResult.getId());
		assertEquals(tvShowId, tvShowResult.getId());
	}
}