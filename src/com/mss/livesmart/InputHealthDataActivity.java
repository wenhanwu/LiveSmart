package com.mss.livesmart;

import java.util.Date;

import com.mss.livesmart.data.DatabaseHandler;
import com.mss.livesmart.entities.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputHealthDataActivity extends Activity {
	
	EditText t_distance, t_duration, t_steps;
	Button b_save_activity;
	String s_duration, s_distance, s_steps;
	String toast_msg;
	
	HealthDatabaseHandler dbHandler = new HealthDatabaseHandler(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_health_data);
		
		setupScreenComponents();
		
		b_save_activity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// check if the values are entered
				if(s_duration != null && s_distance != null && s_steps != null &&
				   s_duration.length() != 0 && s_distance.length() != 0 && s_steps.length() != 0){
					
					Activities activities = new Activities(
							Integer.valueOf(s_distance), 
							Double.valueOf(s_duration), 
							new Date().toString(), 
							new Date().toString(), 
							Integer.valueOf(s_steps));
					dbHandler.addActivitiesEntry(activities);
				}
				
			}
		});

	}

	private void setupScreenComponents(){
		t_distance = (EditText) findViewById(R.id.distance);
		t_duration = (EditText) findViewById(R.id.duration);
		t_steps = (EditText) findViewById(R.id.steps);

		b_save_activity = (Button) findViewById(R.id.save_activity);
	}
}
