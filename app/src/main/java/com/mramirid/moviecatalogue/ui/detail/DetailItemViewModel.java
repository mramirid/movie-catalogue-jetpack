package com.mramirid.moviecatalogue.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mramirid.moviecatalogue.data.source.MovieCatalogueRepository;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

public class DetailItemViewModel extends ViewModel {

	private int itemId;
	private String itemType;
	private MovieCatalogueRepository movieCatalogueRepository;

	public DetailItemViewModel(MovieCatalogueRepository movieCatalogueRepository) {
		this.movieCatalogueRepository = movieCatalogueRepository;
	}

	void setItemId(int itemId) {
		this.itemId = itemId;
	}

	void setItemType(String itemType) {
		this.itemType = itemType;
	}

	LiveData<ItemEntity> getItem() {
		return movieCatalogueRepository.getItem(itemType, itemId);
	}
}
