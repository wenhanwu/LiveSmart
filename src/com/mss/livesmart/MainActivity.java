package com.mss.livesmart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {
	MyImageView joke;

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
	}
}