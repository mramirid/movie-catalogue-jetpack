package com.mramirid.moviecatalogue.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.FakeDataDummy;
import com.mramirid.moviecatalogue.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DetailItemViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private DetailItemViewModel detailItemViewModel;
	private ItemEntity dummyMovie = FakeDataDummy.getDummyMovies().get(0);
	private ItemEntity dummyTvShow = FakeDataDummy.getDummyTvShows().get(0);
	private MovieCatalogueRepository movieCatalogueRepository = mock(MovieCatalogueRepository.class);

	@Before
	public void setUp() {
		detailItemViewModel = new DetailItemViewModel(movieCatalogueRepository);
	}

	@Test
	public void getMovie() {
		Resource<ItemEntity> resourceMovie = Resource.success(dummyMovie);
		MutableLiveData<Resource<ItemEntity>> movie = new MutableLiveData<>();
		movie.setValue(resourceMovie);

		when(movieCatalogueRepository.getItem(dummyMovie.getId())).thenReturn(movie);

		//noinspection unchecked
		Observer<Resource<ItemEntity>> observer = mock(Observer.class);

		detailItemViewModel.setItemId(dummyMovie.getId());
		detailItemViewModel.item.observeForever(observer);

		verify(observer).onChanged(resourceMovie);

		assertNotNull(detailItemViewModel.item.getValue());
		ItemEntity movieResult = detailItemViewModel.item.getValue().data;
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
		Resource<ItemEntity> resourceTvShow = Resource.success(dummyTvShow);
		MutableLiveData<Resource<ItemEntity>> tvShow = new MutableLiveData<>();
		tvShow.setValue(resourceTvShow);

		when(movieCatalogueRepository.getItem(dummyTvShow.getId())).thenReturn(tvShow);

		//noinspection unchecked
		Observer<Resource<ItemEntity>> observer = mock(Observer.class);

		detailItemViewModel.setItemId(dummyTvShow.getId());
		detailItemViewModel.item.observeForever(observer);

		verify(observer).onChanged(resourceTvShow);

		assertNotNull(detailItemViewModel.item.getValue());
		ItemEntity tvShowResult = detailItemViewModel.item.getValue().data;
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