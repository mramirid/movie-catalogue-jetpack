package com.mramirid.moviecatalogue.data.source;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.mramirid.moviecatalogue.data.source.local.LocalRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.remote.ApiResponse;
import com.mramirid.moviecatalogue.data.source.remote.RemoteRepository;
import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;
import com.mramirid.moviecatalogue.utils.AppExecutors;
import com.mramirid.moviecatalogue.vo.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class MovieCatalogueRepository implements MovieCatalogueDataSource {

	private volatile static MovieCatalogueRepository INSTANCE = null;

	private final RemoteRepository remoteRepository;
	private final LocalRepository localRepository;
	private final AppExecutors appExecutors;

	private MovieCatalogueRepository(@NonNull RemoteRepository remoteRepository, @NonNull LocalRepository localRepository, @NonNull AppExecutors appExecutors) {
		this.remoteRepository = remoteRepository;
		this.localRepository = localRepository;
		this.appExecutors = appExecutors;
	}

	public static MovieCatalogueRepository getInstance(RemoteRepository remoteRepository, LocalRepository localRepository, AppExecutors appExecutors) {
		if (INSTANCE == null) {
			synchronized (MovieCatalogueRepository.class) {
				if (INSTANCE == null)
					INSTANCE = new MovieCatalogueRepository(remoteRepository, localRepository, appExecutors);
			}
		}
		return INSTANCE;
	}

	@Override
	public LiveData<Resource<PagedList<ItemEntity>>> getMovies(boolean reFetch) {
		return new NetworkBoundResource<PagedList<ItemEntity>, List<ItemResponse>>(appExecutors) {
			@Override
			protected LiveData<PagedList<ItemEntity>> loadFromDB() {
				return new LivePagedListBuilder<>(localRepository.getItemsPaged(TYPE_MOVIE), 20).build();
			}

			@Override
			protected Boolean shouldFetch(PagedList<ItemEntity> data) {
				return (data == null) || (data.size() == 0) || reFetch;
			}

			@Override
			protected LiveData<ApiResponse<List<ItemResponse>>> createCall() {
				return remoteRepository.getMovies();
			}

			@Override
			protected void saveCallResult(List<ItemResponse> data) {
				localRepository.clearNonFavoritesItemByType(TYPE_MOVIE);

				List<ItemEntity> movies = new ArrayList<>();

				for (ItemResponse movieResponse : data) {
					movies.add(new ItemEntity(
							movieResponse.getId(),
							movieResponse.getImgPosterPath(),
							movieResponse.getName(),
							movieResponse.getItemType(),
							movieResponse.getGenres(),
							movieResponse.getDescription(),
							movieResponse.getLanguage(),
							movieResponse.getYear(),
							movieResponse.getRating(),
							false
					));
				}

				localRepository.insertItems(movies);
			}
		}.asLiveData();
	}

	@Override
	public LiveData<Resource<PagedList<ItemEntity>>> getTvShows(boolean reFetch) {
		return new NetworkBoundResource<PagedList<ItemEntity>, List<ItemResponse>>(appExecutors) {
			@Override
			protected LiveData<PagedList<ItemEntity>> loadFromDB() {
				return new LivePagedListBuilder<>(localRepository.getItemsPaged(TYPE_TV_SHOW), 20).build();
			}

			@Override
			protected Boolean shouldFetch(PagedList<ItemEntity> data) {
				return (data == null) || (data.size() == 0) || reFetch;
			}

			@Override
			protected LiveData<ApiResponse<List<ItemResponse>>> createCall() {
				return remoteRepository.getTvShows();
			}

			@Override
			protected void saveCallResult(List<ItemResponse> data) {
				localRepository.clearNonFavoritesItemByType(TYPE_TV_SHOW);

				List<ItemEntity> tvShows = new ArrayList<>();

				for (ItemResponse tvShowResponse : data) {
					tvShows.add(new ItemEntity(
							tvShowResponse.getId(),
							tvShowResponse.getImgPosterPath(),
							tvShowResponse.getName(),
							tvShowResponse.getItemType(),
							tvShowResponse.getGenres(),
							tvShowResponse.getDescription(),
							tvShowResponse.getLanguage(),
							tvShowResponse.getYear(),
							tvShowResponse.getRating(),
							false
					));
				}

				localRepository.insertItems(tvShows);
			}
		}.asLiveData();
	}

	@Override
	public LiveData<Resource<PagedList<ItemEntity>>> getFavoritesPaged(String itemType) {
		return new NetworkBoundResource<PagedList<ItemEntity>, List<ItemResponse>>(appExecutors) {
			@Override
			protected LiveData<PagedList<ItemEntity>> loadFromDB() {
				return new LivePagedListBuilder<>(localRepository.getFavoritesItemPaged(itemType), 20).build();
			}

			@Override
			protected Boolean shouldFetch(PagedList<ItemEntity> data) {
				return false;
			}

			@Override
			protected LiveData<ApiResponse<List<ItemResponse>>> createCall() {
				return null;
			}

			@Override
			protected void saveCallResult(List<ItemResponse> data) {

			}
		}.asLiveData();
	}

	@Override
	public LiveData<Resource<ItemEntity>> getItem(int itemId) {
		return new NetworkBoundResource<ItemEntity, ItemResponse>(appExecutors) {
			@Override
			protected LiveData<ItemEntity> loadFromDB() {
				return localRepository.getItem(itemId);
			}

			@Override
			protected Boolean shouldFetch(ItemEntity data) {
				return false;
			}

			@Override
			protected LiveData<ApiResponse<ItemResponse>> createCall() {
				return null;
			}

			@Override
			protected void saveCallResult(ItemResponse data) {

			}
		}.asLiveData();
	}

	@Override
	public void setFavorite(ItemEntity item, boolean newState) {
		Runnable runnable = () -> localRepository.setFavorite(item, newState);
		appExecutors.diskIO().execute(runnable);
	}

	@Override
	public void clearFavorites(String itemType) {
		Runnable runnable = () -> localRepository.clearFavorites(itemType);
		appExecutors.diskIO().execute(runnable);
	}
}
