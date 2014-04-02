package com.mss.livesmart;

import java.util.Date;

import com.mss.livesmart.entities.Activities;
import com.mss.livesmart.entities.BloodPressures;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class InputDayDataFragment extends Fragment {

	EditText t_distance, t_duration, t_steps;
	Button b_save_activity, b_save_bloodPressure;
	String s_duration, s_distance, s_steps;
	String toast_msg;

	SeekBar heartRate_bar, systolic_bar, diastolic_bar;
	TextView heartRate_reading, systolic_reading, diastolic_reading;
	int heartRate_result, systolic_result, diastolic_result;

	
	HealthDatabaseHandler dbHandler = new HealthDatabaseHandler(getActivity());

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_input_health_data, container, false);
		
		setupScreenComponents(view);
//		checkInputs();

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
					Toast.makeText(getActivity(), toast_msg,
							Toast.LENGTH_LONG).show();
				}

//				clearTextFields();
			}
		});

		heartRate_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int heartRate_value = 0;

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				heartRate_value = progress;
			
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// displays final reading on stop
				heartRate_reading.setText(heartRate_value + " bpm");
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// displays initial heart rate reading
				heartRate_reading.setText(heartRate_value + " bpm");
			}

		});

		systolic_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			int systolic_value = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				systolic_reading.setText(systolic_value + " mm Hg");
				systolic_result = systolic_value;

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				systolic_reading.setText(systolic_value + " mm Hg");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				systolic_value = progress;

			}
		});

		diastolic_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			int diastolic_value = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				diastolic_reading.setText(diastolic_value + " mm Hg");
				diastolic_result = diastolic_value;

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				diastolic_reading.setText(diastolic_value + " mm Hg");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				diastolic_value = progress;

			}
		});

		b_save_bloodPressure.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				BloodPressures bloodPressures = new BloodPressures(
						systolic_result, diastolic_result, new Date().toString(), new Date().toString());
				dbHandler.addBloodPressureEntry(bloodPressures);

				toast_msg = "BP Data inserted successfully";
				Toast.makeText(getActivity(), toast_msg,
						Toast.LENGTH_LONG).show();
				
			}
		});
		return view;
	}
	
	

//	}

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

	private void setupScreenComponents(View view) {
//		t_distance = (EditText) view.findViewById(R.id.distance);
//		t_duration = (EditText) view.findViewById(R.id.duration);
//		t_steps = (EditText) view.findViewById(R.id.steps);

		b_save_activity = (Button) view.findViewById(R.id.save_activity);

		heartRate_bar = (SeekBar) view.findViewById(R.id.heart_rate_bar);
		heartRate_reading = (TextView) view.findViewById(R.id.heart_rate_reading);

		systolic_bar = (SeekBar) view.findViewById(R.id.systolic_bar);
		diastolic_bar = (SeekBar) view.findViewById(R.id.diastolic_bar);
		systolic_reading = (TextView) view.findViewById(R.id.systolic_reading);
		diastolic_reading = (TextView) view.findViewById(R.id.diastolic_reading);
		
		b_save_bloodPressure = (Button) view.findViewById(R.id.save_blood_pressure);
	}

//	private void clearTextFields() {
//
//		t_distance.getText().clear();
//		t_duration.getText().clear();
//		t_steps.getText().clear();
//
//	}

}
