package com.mss.livesmart.data;

import com.mss.livesmart.R;
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
	EditText add_weight, add_distance, add_sleepmin;
	Button add_save_btn, add_view_all, update_btn, update_view_all;
	LinearLayout add_view, update_view;
	String valid_distance = null, valid_sleepmin = null, valid_weight = null,
			Toast_msg = null, valid_user_id = "";
	int RECOMMENDATION_ID;
	DatabaseHandler dbHandler = new DatabaseHandler(this);

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
		} else {

			update_view.setVisibility(View.VISIBLE);
			add_view.setVisibility(View.GONE);
			RECOMMENDATION_ID = Integer.parseInt(getIntent().getStringExtra("RECOMMENDATION_ID"));

			DataEntry c = dbHandler.Get_Recommendation(RECOMMENDATION_ID);

			add_weight.setText(c.getWeight());
			add_distance.setText(c.getDistance());
			add_sleepmin.setText(c.getSleepmin());
			// dbHandler.close();
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

		add_sleepmin.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_SleepTime(add_sleepmin);
			}
		});

		add_weight.addTextChangedListener(new TextWatcher() {

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
				Is_Valid_Weight(add_weight);
			}
		});

		add_save_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// check the value state is null or not
				if (valid_weight != null && valid_distance != null
						&& valid_sleepmin != null && valid_weight.length() != 0
						&& valid_distance.length() != 0
						&& valid_sleepmin.length() != 0) {

					dbHandler.Add_Recommendation(new DataEntry(valid_weight,
							valid_distance, valid_sleepmin));
					Toast_msg = "Data inserted successfully";
					Show_Toast(Toast_msg);
					Reset_Text();

				}

			}
		});

		update_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				valid_weight = add_weight.getText().toString();
				valid_distance = add_distance.getText().toString();
				valid_sleepmin = add_sleepmin.getText().toString();

				// check the value state is null or not
				if (valid_weight != null && valid_distance != null
						&& valid_sleepmin != null && valid_weight.length() != 0
						&& valid_distance.length() != 0
						&& valid_sleepmin.length() != 0) {

					dbHandler.Update_Recommendation(new DataEntry(RECOMMENDATION_ID,
							valid_weight, valid_distance, valid_sleepmin));
					dbHandler.close();
					Toast_msg = "Data Update successfully";
					Show_Toast(Toast_msg);
					Reset_Text();
				} else {
					Toast_msg = "Sorry Some Fields are missing.\nPlease Fill up all.";
					Show_Toast(Toast_msg);
				}

			}
		});
		update_view_all.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent view_user = new Intent(AddUpdateRecActivity.this,
						RecommendationActivity.class);
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
						RecommendationActivity.class);
				view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(view_user);
				finish();
			}
		});

	}

	public void Set_Add_Update_Screen() {

		add_weight = (EditText) findViewById(R.id.add_weight);
		add_distance = (EditText) findViewById(R.id.add_distance);
		add_sleepmin = (EditText) findViewById(R.id.add_sleepmin);

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

	public void Is_Valid_SleepTime(EditText edt) {

		valid_sleepmin = edt.getText().toString();

	}

	public void Is_Valid_Weight(EditText edt) throws NumberFormatException {

		valid_weight = edt.getText().toString();
	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	public void Reset_Text() {

		add_weight.getText().clear();
		add_distance.getText().clear();
		add_sleepmin.getText().clear();

	}

}
