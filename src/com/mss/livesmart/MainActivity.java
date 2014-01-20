package com.mss.livesmart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyImageView joke;
	MyImageView photoAlbum;
	MyImageView heartRate;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		joke = (MyImageView) findViewById(R.id.c_joke);
		joke.setOnClickIntent(new MyImageView.OnViewClick() {

			@SuppressLint("ShowToast")
			@Override
			public void onClick() {
				Toast.makeText(MainActivity.this, "clicked", 100)
						.show();
			}
		});
		
		photoAlbum = (MyImageView) findViewById(R.id.c_idea);
		photoAlbum.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new Intent
		        Intent photoAlbumScreen = new Intent(getApplicationContext(), PhotoAlbumActivity.class);
		        startActivity(photoAlbumScreen);
			}
		});
		
		heartRate = (MyImageView) findViewById(R.id.c_recommend);
		heartRate.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new Intent
		        Intent heartRateScreen = new Intent(getApplicationContext(), HeartRateActivity.class);
		        startActivity(heartRateScreen);
			}
		});
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            //action when search button is clicked
	            return true;
	        case R.id.action_settings:
	            //action when setting button is clicked
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}