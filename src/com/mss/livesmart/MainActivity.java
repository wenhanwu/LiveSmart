package com.mss.livesmart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyImageView healthCenter;
	MyImageView	messageCenter;
	MyImageView photoAlbum;
	MyImageView heartRate;
	SharedPreferences settings;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		settings = getSharedPreferences("AppSettings", 0);
		if(settings.getBoolean("RunFirstTime", true)) {
			Intent personalInfoScreen = new Intent(getApplicationContext(), PersonalInfoActivity.class);
			startActivity(personalInfoScreen);
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("RunFirstTime", false);
			editor.commit();
		}
		healthCenter = (MyImageView) findViewById(R.id.c_health_center);
		healthCenter.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new Intent
		        Intent healthCenterScreen = new Intent(getApplicationContext(), HealthCenterActivity.class);
		        startActivity(healthCenterScreen);
			}
		});

		messageCenter = (MyImageView) findViewById(R.id.c_message_center);
		messageCenter.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new Intent
		        Intent messageCenterScreen = new Intent(getApplicationContext(), MessageCenterActivity.class);
		        startActivity(messageCenterScreen);
			}
		});
		
		photoAlbum = (MyImageView) findViewById(R.id.c_photo_album);
		photoAlbum.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new intent
		        Intent photoAlbumScreen = new Intent(getApplicationContext(), PhotoAlbumActivity.class);
		        startActivity(photoAlbumScreen);
			}
		});
		
		heartRate = (MyImageView) findViewById(R.id.c_heart_rate);
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
	            //Starting a new intent
	            Intent personalInfoScreen = new Intent(getApplicationContext(), PersonalInfoActivity.class);
	            startActivity(personalInfoScreen);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}