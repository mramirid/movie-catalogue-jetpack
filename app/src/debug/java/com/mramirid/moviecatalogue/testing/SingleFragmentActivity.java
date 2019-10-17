package com.mramirid.moviecatalogue.testing;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mramirid.moviecatalogue.R;

public class SingleFragmentActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View content = new FrameLayout(this);
		FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT,
				Gravity.CENTER
		);
		content.setLayoutParams(params);
		content.setId(R.id.fl_container);
		setContentView(content);
	}

	public void setFragment(Fragment fragment) {
		getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.fl_container, fragment, "TEST")
				.commit();
	}
}
