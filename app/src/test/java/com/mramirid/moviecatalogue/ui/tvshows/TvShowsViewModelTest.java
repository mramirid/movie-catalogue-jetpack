package com.mramirid.moviecatalogue.ui.tvshows;

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
		MutableLiveData<Resource<PagedList<ItemEntity>>> dummyTvShows = new MutableLiveData<>();

		//noinspection unchecked
		PagedList<ItemEntity> pagedList = mock(PagedList.class);

		dummyTvShows.setValue(Resource.success(pagedList));

		when(movieCatalogueRepository.getTvShows(false)).thenReturn(dummyTvShows);

		//noinspection unchecked
		Observer<Resource<PagedList<ItemEntity>>> observer = mock(Observer.class);

		viewModel.fetch(false);
		viewModel.tvShows.observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));
	}
}