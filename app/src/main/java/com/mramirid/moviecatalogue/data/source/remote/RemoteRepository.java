package com.mramirid.moviecatalogue.data.source.remote;

import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;
import com.mramirid.moviecatalogue.utils.EspressoIdlingResource;
import com.mramirid.moviecatalogue.utils.JsonHelper;

import java.util.ArrayList;

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

	public void getMovies(LoadItemsCallback callback) {
		EspressoIdlingResource.increment();
		jsonHelper.loadMovies(callback);
	}

	public void getTvShows(LoadItemsCallback callback) {
		EspressoIdlingResource.increment();
		jsonHelper.loadTvShows(callback);
	}

	public interface LoadItemsCallback {
		void onItemsReceived(ArrayList<ItemResponse> itemResponses);
		void onDataNotAvailable();
	}
}
