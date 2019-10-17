package com.mramirid.moviecatalogue.data.source.remote.response;

public class ItemResponse {

	private int id;
	private String imgPosterPath, name, itemType, genres, description, language, year;
	private float rating;

	public ItemResponse(int id, String imgPosterPath, String name, String itemType, String genres, String description, String language, String year, float rating) {
		this.id = id;
		this.imgPosterPath = imgPosterPath;
		this.name = name;
		this.itemType = itemType;
		this.genres = genres;
		this.description = description;
		this.language = language;
		this.year = year;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImgPosterPath() {
		return imgPosterPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemType() {
		return itemType;
	}

	public String getGenres() {
		return genres;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String getYear() {
		return year;
	}

	public float getRating() {
		return rating;
	}

}
