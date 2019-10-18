package com.mramirid.moviecatalogue.data.source.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "itemEntities")
public class ItemEntity {

	@PrimaryKey
	@ColumnInfo(name = "id")
	private int id;

	@ColumnInfo(name = "imagePosterPath")
	private String imgPosterPath;

	@ColumnInfo(name = "name")
	private String name;

	@ColumnInfo(name = "itemType")
	private String itemType;

	@ColumnInfo(name = "genres")
	private String genres;

	@ColumnInfo(name = "description")
	private String description;

	@ColumnInfo(name = "language")
	private String language;

	@ColumnInfo(name = "year")
	private String year;

	@ColumnInfo(name = "rating")
	private float rating;

	@ColumnInfo(name = "favorited")
	private boolean favorited;

	public static final String TYPE_MOVIE = "movie";
	public static final String TYPE_TV_SHOW = "tv_show";

	public ItemEntity(int id, String imgPosterPath, String name, String itemType, String genres,
					  String description, String language, String year, float rating, boolean favorited) {
		this.id = id;
		this.imgPosterPath = imgPosterPath;
		this.name = name;
		this.itemType = itemType;
		this.genres = genres;
		this.description = description;
		this.language = language;
		this.year = year;
		this.rating = rating;
		this.favorited = favorited;
	}

	public int getId() {
		return id;
	}

	public String getImgPosterPath() {
		return imgPosterPath;
	}

	public String getName() {
		return name;
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

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
}
