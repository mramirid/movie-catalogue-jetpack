package com.mramirid.moviecatalogue.data.source.remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;
import com.mramirid.moviecatalogue.utils.JsonHelper;

import java.util.List;

public class RemoteRepository {

	private static RemoteRepository INSTANCE;
	private JsonHelper jsonHelper;

	private RemoteRepository(JsonHelper jsonHelper) {
		this.jsonHelper = jsonHelper;
	}

	public static RemoteRepository getInstance(JsonHelper jsonHelper) {
		if (INSTANCE == null)
			INSTANCE = new RemoteRepository(jsonHelper);
		return INSTANCE;
	}

	public LiveData<ApiResponse<List<ItemResponse>>> getMovies() {
		EspressoIdlingResource.increment();

		MutableLiveData<ApiResponse<List<ItemResponse>>> resultMovies = new MutableLiveData<>();

		Observer<List<ItemResponse>> resultMoviesObserver = new Observer<List<ItemResponse>>() {
			@Override
			public void onChanged(List<ItemResponse> itemResponses) {
				if (itemResponses.size() != 0)
					resultMovies.setValue(ApiResponse.success(itemResponses));
				else
					resultMovies.setValue(ApiResponse.error("Movies request failed", itemResponses));

				if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow())
					EspressoIdlingResource.decrement();

				jsonHelper.loadMovies().removeObserver(this);
			}
		};

		jsonHelper.loadMovies().observeForever(resultMoviesObserver);

		return resultMovies;
	}

	public LiveData<ApiResponse<List<ItemResponse>>> getTvShows() {
		EspressoIdlingResource.increment();

		MutableLiveData<ApiResponse<List<ItemResponse>>> resultTvShows = new MutableLiveData<>();

		Observer<List<ItemResponse>> resultTvShowsObserver = new Observer<List<ItemResponse>>() {
			@Override
			public void onChanged(List<ItemResponse> itemResponses) {
				if (itemResponses.size() != 0)
					resultTvShows.setValue(ApiResponse.success(itemResponses));
				else
					resultTvShows.setValue(ApiResponse.error("Tv Shows request failed", itemResponses));

				if (!EspressoIdlingResource.getEspressoIdlingResource().isIdleNow())
					EspressoIdlingResource.decrement();

				jsonHelper.loadMovies().removeObserver(this);
			}
		};

		jsonHelper.loadTvShows().observeForever(resultTvShowsObserver);

		return resultTvShows;
	}
}
