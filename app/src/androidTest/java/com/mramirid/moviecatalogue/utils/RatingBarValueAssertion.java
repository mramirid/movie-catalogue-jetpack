package com.mramirid.moviecatalogue.utils;

import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RatingBarValueAssertion implements ViewAssertion {

	private final float expectedCount;

	public RatingBarValueAssertion(float expectedCount) {
		this.expectedCount = expectedCount;
	}

	@Override
	public void check(View view, NoMatchingViewException noViewFoundException) {
		if (noViewFoundException != null)
			throw noViewFoundException;

		RatingBar ratingBar = (RatingBar) view;
		assertNotNull(ratingBar);
		// Karena tiap kali lebih 0.25 (.25 atau .75) atau lebihnya lagi, maka ratingBar akan menambahkan 0.25
		assertEquals(ratingBar.getRating(), expectedCount, 0.25);
	}
}
