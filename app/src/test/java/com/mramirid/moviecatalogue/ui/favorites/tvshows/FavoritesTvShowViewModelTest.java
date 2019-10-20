package com.mramirid.moviecatalogue.ui.favorites.tvshows;

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

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FavoritesTvShowViewModelTest {

	@Rule
	public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

	private FavoritesTvShowViewModel favoritesTvShowViewModel;
	private MovieCatalogueRepository movieCatalogueRepository;

	@Before
	public void setUp() {
		movieCatalogueRepository = mock(MovieCatalogueRepository.class);
		favoritesTvShowViewModel = new FavoritesTvShowViewModel(movieCatalogueRepository);
	}

	@Test
	public void getFavoritesTvShow() {
		MutableLiveData<Resource<PagedList<ItemEntity>>> dummyTvShows = new MutableLiveData<>();

		//noinspection unchecked
		PagedList<ItemEntity> pagedList = mock(PagedList.class);

		dummyTvShows.setValue(Resource.success(pagedList));

		when(movieCatalogueRepository.getFavoritesPaged(TYPE_TV_SHOW)).thenReturn(dummyTvShows);

		//noinspection unchecked
		Observer<Resource<PagedList<ItemEntity>>> observer = mock(Observer.class);

		favoritesTvShowViewModel.getFavoritesPaged().observeForever(observer);

		verify(observer).onChanged(Resource.success(pagedList));
	}
}