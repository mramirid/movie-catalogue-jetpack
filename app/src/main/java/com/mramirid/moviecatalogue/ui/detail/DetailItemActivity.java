package com.mramirid.moviecatalogue.ui.detail;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.utils.GlideApp;
import com.mramirid.moviecatalogue.viewmodel.ViewModelFactory;

public class DetailItemActivity extends AppCompatActivity {

	public static final String EXTRA_ITEM_ID = "extra_item_id";

	private ImageView imgCover, imgPhoto;
	private TextView tvName, tvGenres, tvYear, tvLanguage, tvDescription;
	private RatingBar ratingBar;
	private FloatingActionButton fabFavorite;

	private DetailItemViewModel detailItemViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_item);

		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setTitle("Description");
		}

		// Set back arrow color
		if (toolbar.getNavigationIcon() != null)
			toolbar.getNavigationIcon().setColorFilter(getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);

		toolbar.setNavigationOnClickListener(view -> onBackPressed());

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
		fabFavorite = findViewById(R.id.fab_favorite);

		detailItemViewModel = obtainViewModel(this);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			int itemId = extras.getInt(EXTRA_ITEM_ID, 0);
			if (itemId != 0) {
				detailItemViewModel.setItemId(itemId);
			}
		}

		detailItemViewModel.item.observe(this, itemEntityResource -> {
			if (itemEntityResource != null) {
				switch (itemEntityResource.status) {
					case LOADING:
						progressBar.setVisibility(View.VISIBLE);
						svContainer.setVisibility(View.GONE);
						break;
					case SUCCESS:
						if (itemEntityResource.data != null) {
							progressBar.setVisibility(View.GONE);
							svContainer.setVisibility(View.VISIBLE);
							boolean state = itemEntityResource.data.isFavorited();
							setFavoriteButtonState(state);
							populateDetailItem(itemEntityResource.data);
						}
						break;
					case ERROR:
						progressBar.setVisibility(View.GONE);
						Toast.makeText(this, "Item not found", Toast.LENGTH_SHORT).show();
						break;
				}
			}
		});

		fabFavorite.setOnClickListener(view -> detailItemViewModel.setFavorite());
	}

	private void setFavoriteButtonState(boolean state) {
		if (state)
			fabFavorite.setImageDrawable(getDrawable(R.drawable.ic_favorite_red_24dp));
		else
			fabFavorite.setImageDrawable(getDrawable(R.drawable.ic_favorite_border_red_24dp));
	}

	private DetailItemViewModel obtainViewModel(AppCompatActivity activity) {
		ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
		return ViewModelProviders.of(activity, factory).get(DetailItemViewModel.class);
	}

	private void populateDetailItem(ItemEntity item) {
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
