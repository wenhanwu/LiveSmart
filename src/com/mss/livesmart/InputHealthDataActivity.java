package com.mss.livesmart;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class InputHealthDataActivity extends Activity {
	
	EditText t_distance, t_duration, t_steps;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_health_data);
		
		setupScreenComponents();
	}

	private void setupScreenComponents(){
		t_distance = (EditText) findViewById(R.id.distance);
		t_duration = (EditText) findViewById(R.id.duration);
		t_steps = (EditText) findViewById(R.id.steps);
	}
}
