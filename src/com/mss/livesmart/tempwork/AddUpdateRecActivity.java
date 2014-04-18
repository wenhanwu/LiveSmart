package com.mss.livesmart.tempwork;

import com.mss.livesmart.HealthDatabaseHandler;
import com.mss.livesmart.R;
import com.mss.livesmart.data.ActivitiesActivity;
import com.mss.livesmart.entities.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AddUpdateRecActivity extends Activity {
	EditText add_duration, add_distance, add_steps;
	Button add_save_btn, add_view_all, update_btn, update_view_all;
	LinearLayout add_view, update_view;
	String valid_distance = null, valid_steps = null, valid_duration = null,
			Toast_msg = null, valid_user_id = "";
	int RECOMMENDATION_ID;
	HealthDatabaseHandler dbHandler = new HealthDatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_update_page);

		// set screen
		Set_Add_Update_Screen();

		// set visibility of view as per calling activity
		String called_from = getIntent().getStringExtra("called");

		if (called_from.equalsIgnoreCase("add")) {
			add_view.setVisibility(View.VISIBLE);
			update_view.setVisibility(View.GONE);
		}  
		add_distance.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				// min lenth 10 and max lenth 12 (2 extra for - as per phone
				// matcher format)
				Is_Valid_Distance( add_distance);
			}
		});
		add_distance
				.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

		add_steps.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Steps(add_steps);
			}
		});

		add_duration.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Duration(add_duration);
			}
		});

		add_save_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// check the value state is null or not
				if (valid_duration != null && valid_distance != null
						&& valid_steps != null && valid_duration.length() != 0
						&& valid_distance.length() != 0
						&& valid_steps.length() != 0) {

					dbHandler.addActivitiesEntry(new Activities(Integer.valueOf(valid_duration),
							Double.valueOf(valid_distance), Integer.valueOf(valid_steps)));
					Toast_msg = "Data inserted successfully";
					Show_Toast(Toast_msg);
					Reset_Text();

				}

			}
		});

		 
		update_view_all.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent view_user = new Intent(AddUpdateRecActivity.this,
						ActivitiesActivity.class);
				view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(view_user);
				finish();
			}
		});

		add_view_all.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent view_user = new Intent(AddUpdateRecActivity.this,
						ActivitiesActivity.class);
				view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(view_user);
				finish();
			}
		});

	}

	public void Set_Add_Update_Screen() {

		add_duration = (EditText) findViewById(R.id.add_duration);
		add_distance = (EditText) findViewById(R.id.add_distance);
		add_steps = (EditText) findViewById(R.id.add_steps);

		add_save_btn = (Button) findViewById(R.id.add_save_btn);
		update_btn = (Button) findViewById(R.id.update_btn);
		add_view_all = (Button) findViewById(R.id.add_view_all);
		update_view_all = (Button) findViewById(R.id.update_view_all);

		add_view = (LinearLayout) findViewById(R.id.add_view);
		update_view = (LinearLayout) findViewById(R.id.update_view);

		add_view.setVisibility(View.GONE);
		update_view.setVisibility(View.GONE);

	}

	public void Is_Valid_Distance( EditText edt)
			throws NumberFormatException {
		valid_distance = edt.getText().toString();

	} // END OF Edittext validation

	public void Is_Valid_Steps(EditText edt) {

		valid_steps = edt.getText().toString();

	}

	public void Is_Valid_Duration(EditText edt) throws NumberFormatException {

		valid_duration = edt.getText().toString();
	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void Reset_Text() {

		add_duration.getText().clear();
		add_distance.getText().clear();
		add_steps.getText().clear();

	}

}
