package com.mramirid.moviecatalogue.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.ui.detail.DetailItemActivity;
import com.mramirid.moviecatalogue.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

	private final Activity activity;
	private List<ItemEntity> items = new ArrayList<>();

	public ItemsAdapter(Activity activity) {
		this.activity = activity;
	}

	private List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		if (items != null) {
			this.items.clear();
			this.items.addAll(items);
		}
	}

	@NonNull
	@Override
	public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
		return new ItemsViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
		holder.tvName.setText(getItems().get(position).getName());
		holder.tvYear.setText(String.valueOf(getItems().get(position).getYear()));
		holder.ratingBar.setRating(getItems().get(position).getRating());
		GlideApp.with(holder.itemView.getContext())
				.load(getItems().get(position).getImgPosterPath())
				.apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
				.apply(new RequestOptions().transform(new RoundedCorners(40)))
				.into(holder.imgPoster);

		holder.itemView.setOnClickListener(view -> {
			Intent moveToDetailItem = new Intent(activity, DetailItemActivity.class);
			moveToDetailItem.putExtra(DetailItemActivity.EXTRA_ITEM_ID, getItems().get(position).getId());
			moveToDetailItem.putExtra(DetailItemActivity.EXTRA_ITEM_TYPE, getItems().get(position).getItemType());
			activity.startActivity(moveToDetailItem);
		});
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	class ItemsViewHolder extends RecyclerView.ViewHolder {

		final ImageView imgPoster;
		final TextView tvName, tvYear;
		final RatingBar ratingBar;

		ItemsViewHolder(@NonNull View itemView) {
			super(itemView);

			imgPoster = itemView.findViewById(R.id.img_poster);
			tvName = itemView.findViewById(R.id.tv_name);
			tvYear = itemView.findViewById(R.id.tv_year);
			ratingBar = itemView.findViewById(R.id.rb_star);
		}
	}
}
