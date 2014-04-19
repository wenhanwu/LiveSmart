package com.mss.livesmart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecommendationDetailActivity extends Activity {

	String position = "1";
	String heading = "";
	String subtitle = "";
	String description = "";
	String date = "";
	String iconfile = "";
	ImageButton iconImage;

	TextView heading_view;
	TextView subtitle_view;
	TextView description_view;
	TextView date_view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recommendation_detail);

		try {

			// handle for the UI elements
			iconImage = (ImageButton) findViewById(R.id.imageButtonAlpha);
			// Text fields
			heading_view = (TextView) findViewById(R.id.rmdHeading);
			subtitle_view = (TextView) findViewById(R.id.rmdSubtitle);
			description_view = (TextView) findViewById(R.id.description_view);
			date_view = (TextView) findViewById(R.id.date_view);

			// Get position to display
			Intent i = getIntent();

			this.position = i.getStringExtra("position");
			this.heading = i.getStringExtra("heading");
			this.subtitle = i.getStringExtra("subtitle");
			this.description = i.getStringExtra("description");
			this.date = i.getStringExtra("date");
			this.iconfile = i.getStringExtra("icon");

			String uri = "drawable/" + "d" + iconfile;
			int imageBtnResource = getResources().getIdentifier(uri, null,
					getPackageName());
			Drawable dimgbutton = getResources().getDrawable(imageBtnResource);

			// text elements
			heading_view.setText(heading);
			subtitle_view.setText(subtitle);
			description_view.setText(description);
			date_view.setText(date);

			// thumb_image.setImageDrawable(image);
			iconImage.setImageDrawable(dimgbutton);

		}

		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

}
