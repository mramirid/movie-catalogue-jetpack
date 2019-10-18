package com.mramirid.moviecatalogue.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.mramirid.moviecatalogue.R;
import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.ui.detail.DetailItemActivity;
import com.mramirid.moviecatalogue.utils.GlideApp;

public class ItemsPagedAdapter extends PagedListAdapter<ItemEntity, ItemsPagedAdapter.ItemsViewHolder> {

	private static DiffUtil.ItemCallback<ItemEntity> DIFF_CALLBACK = new DiffUtil.ItemCallback<ItemEntity>() {
		@Override
		public boolean areItemsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
			return oldItem.getId() == newItem.getId();
		}

		@SuppressLint("DiffUtilEquals")
		@Override
		public boolean areContentsTheSame(@NonNull ItemEntity oldItem, @NonNull ItemEntity newItem) {
			return oldItem.equals(newItem);
		}
	};

	public ItemsPagedAdapter() {
		super(DIFF_CALLBACK);
	}

	@NonNull
	@Override
	public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
		return new ItemsViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
		final ItemEntity item = getItem(position);
		if (item != null) {
			holder.tvName.setText(item.getName());
			holder.tvYear.setText(item.getYear());
			holder.ratingBar.setRating(item.getRating());
			GlideApp.with(holder.itemView.getContext())
					.load(item.getImgPosterPath())
					.apply(RequestOptions.placeholderOf(R.drawable.ic_broken_image_black_24dp).error(R.drawable.ic_broken_image_black_24dp))
					.apply(new RequestOptions().transform(new RoundedCorners(40)))
					.into(holder.imgPoster);

			holder.itemView.setOnClickListener(view -> {
				Context context = holder.itemView.getContext();
				Intent moveToDetailItem = new Intent(context, DetailItemActivity.class);
				moveToDetailItem.putExtra(DetailItemActivity.EXTRA_ITEM_ID, item.getId());
				moveToDetailItem.putExtra(DetailItemActivity.EXTRA_ITEM_TYPE, item.getItemType());
				context.startActivity(moveToDetailItem);
			});
		}
	}

	public ItemEntity getItemById(int swipedPosition) {
		return getItem(swipedPosition);
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
