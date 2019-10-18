package com.mramirid.moviecatalogue.ui.movies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.vo.Resource;

public class MoviesViewModel extends ViewModel {

	private MovieCatalogueRepository movieCatalogueRepository;

	private MutableLiveData<Boolean> fetchNow = new MutableLiveData<>();

	public MoviesViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	LiveData<Resource<PagedList<ItemEntity>>> movies = Transformations.switchMap(
			fetchNow, input -> movieCatalogueRepository.getMovies(input)
	);

	void fetch(boolean fetchNow) {
		this.fetchNow.setValue(fetchNow);
	}
}