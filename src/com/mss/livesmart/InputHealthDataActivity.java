package com.mss.livesmart;

import java.util.Date;

import com.mss.livesmart.entities.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
		checkInputs();

		b_save_activity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// check if the values are entered
				if (s_duration != null && s_distance != null && s_steps != null
						&& s_duration.length() != 0 && s_distance.length() != 0
						&& s_steps.length() != 0) {

					Activities activities = new Activities(Integer
							.valueOf(s_distance), Double.valueOf(s_duration),
							new Date().toString(), new Date().toString(),
							Integer.valueOf(s_steps));
					dbHandler.addActivitiesEntry(activities);

					toast_msg = "Data inserted successfully";
					Toast.makeText(getApplicationContext(), toast_msg,
							Toast.LENGTH_LONG).show();
				}

				clearTextFields();
			}
		});

	}

	private void checkInputs() {

		t_distance.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

				s_distance = t_distance.getText().toString();
			}
		});

		t_duration.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

				s_duration = t_duration.getText().toString();
			}
		});

		t_steps.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

				s_steps = t_steps.getText().toString();
			}
		});

	}

	private void setupScreenComponents() {
		t_distance = (EditText) findViewById(R.id.distance);
		t_duration = (EditText) findViewById(R.id.duration);
		t_steps = (EditText) findViewById(R.id.steps);

		b_save_activity = (Button) findViewById(R.id.save_activity);
	}

	private void clearTextFields() {

		t_distance.getText().clear();
		t_duration.getText().clear();
		t_steps.getText().clear();

	}
}
