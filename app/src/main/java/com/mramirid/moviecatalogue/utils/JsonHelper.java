package com.mramirid.moviecatalogue.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mramirid.moviecatalogue.BuildConfig;
import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class JsonHelper {

	public LiveData<List<ItemResponse>> loadMovies() {
		MutableLiveData<List<ItemResponse>> movies = new MutableLiveData<>();
		String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + BuildConfig.API_KEY + "&language=en-US";

		new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				List<ItemResponse> movieResponses = parseJsonToArrayList(new String(responseBody), TYPE_MOVIE);
				movies.postValue(movieResponses);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
				Log.e(this.getClass().getSimpleName(), "onFailure: request movies failed", error);
				movies.postValue(new ArrayList<>());
			}
		});

		return movies;
	}

	public LiveData<List<ItemResponse>> loadTvShows() {
		MutableLiveData<List<ItemResponse>> tvShows = new MutableLiveData<>();
		String url = "https://api.themoviedb.org/3/discover/tv?api_key=" + BuildConfig.API_KEY + "&language=en-US";

		new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				List<ItemResponse> tvShowResponses = parseJsonToArrayList(new String(responseBody), TYPE_TV_SHOW);
				tvShows.postValue(tvShowResponses);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
				Log.e(this.getClass().getSimpleName(), "onFailure: request movies failed", error);
				tvShows.postValue(new ArrayList<>());
			}
		});

		return tvShows;
	}

	private List<ItemResponse> parseJsonToArrayList(String responseJson, String itemsType) {
		List<ItemResponse> itemResponses = new ArrayList<>();

		try {
			JSONObject responseObject = new JSONObject(responseJson);
			JSONArray responseArray = responseObject.getJSONArray("results");

			for (int i = 0; i < responseArray.length(); ++i) {
				JSONObject response = responseArray.getJSONObject(i);

				// ID
				int id = response.getInt("id");

				// Name
				String name = itemsType.equals(TYPE_MOVIE) ? response.getString("title") : response.getString("name");

				// Relase year
				String year = itemsType.equals(TYPE_MOVIE) ? response.getString("release_date") : response.getString("first_air_date");
				year = year.length() > 4 ? year.substring(0, 4) : year;

				// Poster path
				String imgPosterPath = "https://image.tmdb.org/t/p/w342" + response.getString("poster_path");

				// Genres
				JSONArray idGenres = response.getJSONArray("genre_ids");
				HashMap<Integer, String> dataGenres = DataGenres.getGenres();
				StringBuilder stringBuilder = new StringBuilder();

				for (int j = 0; j < idGenres.length(); ++j) {
					int idGenre = idGenres.getInt(j);
					String valueGenre = dataGenres.get(idGenre);
					stringBuilder.append(valueGenre);
					if (j != (idGenres.length() - 1))
						stringBuilder.append(", ");
				}

				String genres = stringBuilder.toString();

				// Descripton
				String description = response.getString("overview");

				// Language
				String language = response.getString("original_language").toUpperCase();

				// Rating
				float rating = (float) response.getDouble("vote_average") / 2;

				ItemResponse itemResponse = new ItemResponse(id, imgPosterPath, name, itemsType, genres, description, language, year, rating);
				itemResponses.add(itemResponse);
			}
		} catch (JSONException e) {
			Log.e(this.getClass().getSimpleName(), "parseJsonToArrayList: " + e.getMessage());
		}

		return itemResponses;
	}
}
