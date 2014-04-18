package com.mss.livesmart;

import java.util.Date;

import com.mss.livesmart.entities.Activities;
import com.mss.livesmart.entities.BloodPressures;
import com.mss.livesmart.sampledata.SampleHealthData;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class InputDayDataFragment extends Fragment {

	Button b_save_activity, b_save_bloodPressure;
	String toast_msg;

	SeekBar distance_bar, duration_bar, step_bar, heartRate_bar, systolic_bar,
			diastolic_bar;
	TextView distance_reading, duration_reading, step_reading,
			heartRate_reading, systolic_reading, diastolic_reading;
	int distance_result, step_result, heartRate_result, systolic_result,
			diastolic_result;
	double duration_result;

	HealthDatabaseHandler dbHandler = new HealthDatabaseHandler(getActivity());

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_input_day,
				container, false);

		setupScreenComponents(view);

		distance_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int distance_value = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				distance_reading.setText(distance_value + " meters");
				distance_result = distance_value;

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				distance_reading.setText(distance_value + " meters");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				distance_value = progress;

			}
		});

		duration_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			double duraton_value = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				duration_reading.setText(duraton_value / 2.0 + " hours");
				duration_result = duraton_value;

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				duration_reading.setText(duraton_value / 2.0 + " hours");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				duraton_value = (double) progress;

			}
		});

		step_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int step_value = 0;

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				step_reading.setText(step_value + " steps");
				step_result = step_value;

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				step_reading.setText(step_value + " steps");

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				step_value = progress;

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
				heartRate_result = heartRate_value;
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

		b_save_activity.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Activities activities = new Activities(distance_result,
						duration_result, new Date().toString(), new Date()
								.toString(), step_result);

				//dbHandler.addActivitiesEntry(activities);
				SampleHealthData.getHealthData().getActivities().add(activities);
				toast_msg = "Data inserted successfully";
				Toast.makeText(getActivity(), toast_msg, Toast.LENGTH_LONG)
						.show();

			}
		});

		b_save_bloodPressure.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				BloodPressures bloodPressures = new BloodPressures(
						systolic_result, diastolic_result, new Date()
								.toString(), new Date().toString());
//				dbHandler.addBloodPressureEntry(bloodPressures);
				SampleHealthData.getHealthData().getBloodPressures().add(bloodPressures);

				toast_msg = "BP Data inserted successfully";
				Toast.makeText(getActivity(), toast_msg, Toast.LENGTH_LONG)
						.show();

			}
		});
		return view;
	}

	private void setupScreenComponents(View view) {

		distance_bar = (SeekBar) view.findViewById(R.id.distance_bar);
		duration_bar = (SeekBar) view.findViewById(R.id.duration_bar);
		step_bar = (SeekBar) view.findViewById(R.id.step_bar);
		distance_reading = (TextView) view.findViewById(R.id.distance_reading);
		duration_reading = (TextView) view.findViewById(R.id.duration_reading);
		step_reading = (TextView) view.findViewById(R.id.step_reading);

		heartRate_bar = (SeekBar) view.findViewById(R.id.heart_rate_bar);
		heartRate_reading = (TextView) view
				.findViewById(R.id.heart_rate_reading);

		systolic_bar = (SeekBar) view.findViewById(R.id.systolic_bar);
		diastolic_bar = (SeekBar) view.findViewById(R.id.diastolic_bar);
		systolic_reading = (TextView) view.findViewById(R.id.systolic_reading);
		diastolic_reading = (TextView) view
				.findViewById(R.id.diastolic_reading);

		b_save_activity = (Button) view.findViewById(R.id.save_activity);
		b_save_bloodPressure = (Button) view
				.findViewById(R.id.save_blood_pressure);
	}

}
