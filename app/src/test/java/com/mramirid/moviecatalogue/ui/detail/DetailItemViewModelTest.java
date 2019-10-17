package com.mramirid.moviecatalogue.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.FakeDataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailItemViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private DetailItemViewModel viewModel;
	private ItemEntity dummyMovie = FakeDataDummy.getDummyMovies().get(0);
	private ItemEntity dummyTvShow = FakeDataDummy.getDummyTvShows().get(0);
	private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

	@Before
	public void setUp() {
		viewModel = new DetailItemViewModel(movieCatalogueRepository);
	}

	@Test
	public void getMovie() {
		MutableLiveData<ItemEntity> movie = new MutableLiveData<>();
		movie.setValue(dummyMovie);
		int movieId = dummyMovie.getId();
		when(movieCatalogueRepository.getItem(TYPE_MOVIE, movieId)).thenReturn(movie);

		viewModel.setItemType(TYPE_MOVIE);
		viewModel.setItemId(movieId);

		Observer<ItemEntity> observer = mock(Observer.class);
		viewModel.getItem().observeForever(observer);
		verify(observer).onChanged(dummyMovie);

		ItemEntity movieResult = viewModel.getItem().getValue();
		assertNotNull(movieResult);
		assertEquals(dummyMovie.getId(), movieResult.getId());
		assertEquals(dummyMovie.getItemType(), movieResult.getItemType());
		assertEquals(dummyMovie.getName(), movieResult.getName());
		assertEquals(dummyMovie.getGenres(), movieResult.getGenres());
		assertEquals(dummyMovie.getRating(), movieResult.getRating(), 0.0001);
		assertEquals(dummyMovie.getYear(), movieResult.getYear());
		assertEquals(dummyMovie.getLanguage(), movieResult.getLanguage());
		assertEquals(dummyMovie.getDescription(), movieResult.getDescription());
	}

	@Test
	public void getTvShow() {
		MutableLiveData<ItemEntity> tvShow = new MutableLiveData<>();
		tvShow.setValue(dummyTvShow);
		int tvShowId = dummyTvShow.getId();
		when(movieCatalogueRepository.getItem(TYPE_TV_SHOW, tvShowId)).thenReturn(tvShow);

		viewModel.setItemType(TYPE_TV_SHOW);
		viewModel.setItemId(tvShowId);

		Observer<ItemEntity> observer = mock(Observer.class);
		viewModel.getItem().observeForever(observer);
		verify(observer).onChanged(dummyTvShow);

		ItemEntity tvShowResult = viewModel.getItem().getValue();
		assertNotNull(tvShowResult);
		assertEquals(dummyTvShow.getId(), tvShowResult.getId());
		assertEquals(dummyTvShow.getItemType(), tvShowResult.getItemType());
		assertEquals(dummyTvShow.getName(), tvShowResult.getName());
		assertEquals(dummyTvShow.getGenres(), tvShowResult.getGenres());
		assertEquals(dummyTvShow.getRating(), tvShowResult.getRating(), 0.0001);
		assertEquals(dummyTvShow.getYear(), tvShowResult.getYear());
		assertEquals(dummyTvShow.getLanguage(), tvShowResult.getLanguage());
		assertEquals(dummyTvShow.getDescription(), tvShowResult.getDescription());
	}
}