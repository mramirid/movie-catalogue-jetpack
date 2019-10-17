package com.mramirid.moviecatalogue.data.source;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.local.LocalRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.remote.RemoteRepository;
import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {

	private volatile static MovieCatalogueRepository INSTANCE = null;

	private final RemoteRepository remoteRepository;
	private final LocalRepository localRepository;
	private final ExecutorService executorService;

	private MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository, @NonNull LocalRepository localRepository, @NonNull ExecutorService executorService) {
		this.remoteRepository = remoteRepository;
		this.localRepository = localRepository;
		this.executorService = executorService;
	}

	public static MovieCatalogueRepository getInstance(RemoteRepository remoteRepository, LocalRepository localRepository, ExecutorService executorService) {
		if (INSTANCE == null) {
			synchronized (MovieCatalogueRepository.class) {
				if (INSTANCE == null)
					INSTANCE = new MovieCatalogueRepository(remoteRepository, localRepository, executorService);
			}
		}
		return INSTANCE;
	}

	@Override
	public LiveData<ArrayList<ItemEntity>> getMovies() {
		MutableLiveData<ArrayList<ItemEntity>> movieResults = new MutableLiveData<>();

		remoteRepository.getMovies(new RemoteRepository.LoadItemsCallback() {
			@Override
			public void onItemsReceived(ArrayList<ItemResponse> itemResponses) {
				ArrayList<ItemEntity> movies = new ArrayList<>();

				for (ItemResponse itemResponse : itemResponses) {
					ItemEntity movie = new ItemEntity(
							itemResponse.getId(),
							itemResponse.getImgPosterPath(),
							itemResponse.getName(),
							itemResponse.getItemType(),
							itemResponse.getGenres(),
							itemResponse.getDescription(),
							itemResponse.getLanguage(),
							itemResponse.getYear(),
							itemResponse.getRating()
					);
					movies.add(movie);
				}

				movieResults.postValue(movies);
			}

			@Override
			public void onDataNotAvailable() {
				Log.e(this.getClass().getSimpleName(), "onDataNotAvailable: getMovies: Request failed");
			}
		});

		return movieResults;
	}

	@Override
	public LiveData<ArrayList<ItemEntity>> getTvShows() {
		MutableLiveData<ArrayList<ItemEntity>> tvShowResults = new MutableLiveData<>();

		remoteRepository.getTvShows(new RemoteRepository.LoadItemsCallback() {
			@Override
			public void onItemsReceived(ArrayList<ItemResponse> itemResponses) {
				ArrayList<ItemEntity> tvShows = new ArrayList<>();

				for (ItemResponse itemResponse : itemResponses) {
					ItemEntity tvShow = new ItemEntity(
							itemResponse.getId(),
							itemResponse.getImgPosterPath(),
							itemResponse.getName(),
							itemResponse.getItemType(),
							itemResponse.getGenres(),
							itemResponse.getDescription(),
							itemResponse.getLanguage(),
							itemResponse.getYear(),
							itemResponse.getRating()
					);
					tvShows.add(tvShow);
				}

				tvShowResults.postValue(tvShows);
			}

			@Override
			public void onDataNotAvailable() {
				Log.e(this.getClass().getSimpleName(), "onDataNotAvailable: getTvShows: Request failed");
			}
		});

		return tvShowResults;
	}

	@Override
	public LiveData<ItemEntity> getItem(String itemType, int id) {
		MutableLiveData<ItemEntity> itemResult = new MutableLiveData<>();

		if (itemType.equals(TYPE_MOVIE)) {
			remoteRepository.getMovies(new RemoteRepository.LoadItemsCallback() {
				@Override
				public void onItemsReceived(ArrayList<ItemResponse> itemResponses) {
					for (ItemResponse itemResponse : itemResponses) {
						if (itemResponse.getId() == id) {
							ItemEntity movie = new ItemEntity(
									itemResponse.getId(),
									itemResponse.getImgPosterPath(),
									itemResponse.getName(),
									itemResponse.getItemType(),
									itemResponse.getGenres(),
									itemResponse.getDescription(),
									itemResponse.getLanguage(),
									itemResponse.getYear(),
									itemResponse.getRating()
							);
							itemResult.postValue(movie);
							break;
						}
					}
				}

				@Override
				public void onDataNotAvailable() {
					Log.e(this.getClass().getSimpleName(), "onDataNotAvailable: getItem: getMovies: Request failed");
				}
			});
		} else if (itemType.equals(TYPE_TV_SHOW)) {
			remoteRepository.getTvShows(new RemoteRepository.LoadItemsCallback() {
				@Override
				public void onItemsReceived(ArrayList<ItemResponse> itemResponses) {
					for (ItemResponse itemResponse : itemResponses) {
						if (itemResponse.getId() == id) {
							ItemEntity tvShow = new ItemEntity(
									itemResponse.getId(),
									itemResponse.getImgPosterPath(),
									itemResponse.getName(),
									itemResponse.getItemType(),
									itemResponse.getGenres(),
									itemResponse.getDescription(),
									itemResponse.getLanguage(),
									itemResponse.getYear(),
									itemResponse.getRating()
							);
							itemResult.postValue(tvShow);
							break;
						}
					}
				}

				@Override
				public void onDataNotAvailable() {
					Log.e(this.getClass().getSimpleName(), "onDataNotAvailable: getItem: getTvShows: Request failed");
				}
			});
		}

		return itemResult;
	}

	@Override
	public void insertFavorite(ItemEntity item) {
		Runnable runnable = () -> localRepository.insertFavorite(item);
		executorService.execute(runnable);
	}

	@Override
	public void deleteFavorite(ItemEntity item) {
		Runnable runnable = () -> localRepository.deleteFavorite(item);
		executorService.execute(runnable);
	}

	@Override
	public LiveData<PagedList<ItemEntity>> getFavoritesPaged(String itemType) {
		return new LivePagedListBuilder<>(localRepository.getFavoritesPaged(itemType), 20).build();
	}
}
