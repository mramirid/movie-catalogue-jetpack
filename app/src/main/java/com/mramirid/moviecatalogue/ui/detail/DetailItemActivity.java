package com.mramirid.moviecatalogue.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.GlideApp;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailItemActivity extends AppCompatActivity {

	public static final String EXTRA_ITEM_ID = "extra_item_id";
	public static final String EXTRA_ITEM_TYPE = "extra_item_type";

	private ImageView imgCover, imgPhoto;
	private TextView tvName, tvGenres, tvYear, tvLanguage, tvDescription;
	private RatingBar ratingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_item);

		imgCover = findViewById(R.id.img_cover);
		imgPhoto = findViewById(R.id.img_photo);
		tvName = findViewById(R.id.tv_name);
		ratingBar = findViewById(R.id.rb_star);
		tvGenres = findViewById(R.id.tv_genres);
		tvYear = findViewById(R.id.tv_year);
		tvLanguage = findViewById(R.id.tv_language);
		tvDescription = findViewById(R.id.tv_description);
		ProgressBar progressBar = findViewById(R.id.progress_bar);
		ScrollView svContainer = findViewById(R.id.sv_container);

		DetailItemViewModel viewModel = obtainViewModel(this);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			int itemId = extras.getInt(EXTRA_ITEM_ID, 0);
			String itemType = extras.getString(EXTRA_ITEM_TYPE);

			if (itemId != 0 && itemType != null) {
				viewModel.setItemId(itemId);
				viewModel.setItemType(itemType);
				svContainer.setVisibility(View.GONE);
				progressBar.setVisibility(View.VISIBLE);
			}
		}

		viewModel.getItem().observe(this, itemEntity -> {
			svContainer.setVisibility(View.VISIBLE);
			progressBar.setVisibility(View.GONE);
			pupulateDetailItem(itemEntity);
		});
	}

	private DetailItemViewModel obtainViewModel(AppCompatActivity activity) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(activity, factory).get(DetailItemViewModel.class);
	}

	private void pupulateDetailItem(ItemEntity item) {
		GlideApp.with(getApplicationContext())
				.load(item.getImgPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
				.into(imgCover);
		GlideApp.with(getApplicationContext())
				.load(item.getImgPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
				.apply(new RequestOptions().transform(new RoundedCorners(40)))
				.into(imgPhoto);
		tvName.setText(item.getName());
		tvGenres.setText(item.getGenres());
		tvYear.setText(String.valueOf(item.getYear()));
		tvLanguage.setText(item.getLanguage());
		tvDescription.setText(item.getDescription());
		ratingBar.setRating(item.getRating());
	}
}
