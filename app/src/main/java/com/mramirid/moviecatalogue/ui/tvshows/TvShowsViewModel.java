package com.mramirid.moviecatalogue.ui.tvshows;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

public class TvShowsViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	private MutableLiveData<Boolean> fetchNow = new MutableLiveData<>();

	public TvShowsViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<Resource<PagedList<ItemEntity>>> tvShows = Transformations.switchMap(
			fetchNow, input -> movieCatalogueRepository.getTvShows(input)
	);

	void fetch(boolean fetchNow) {
		this.fetchNow.setValue(fetchNow);
	}
}