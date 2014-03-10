package com.mss.livesmart.data;

import java.util.ArrayList;

import com.mss.livesmart.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecommendationActivity extends Activity {
	Button add_btn;
	ListView Recommendation_listview;
	ArrayList<DataEntry> recommendation_data = new ArrayList<DataEntry>();
	Recommendation_Adapter cAdapter;
	DatabaseHandler db;
	String Toast_msg;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommendation_list);
		try {
			Recommendation_listview = (ListView) findViewById(R.id.list);
			Recommendation_listview.setItemsCanFocus(false);
			add_btn = (Button) findViewById(R.id.add_btn);

			Set_Referash_Data();

		} catch (Exception e) {
			// TODO: handle exception
			Log.e("some error", "" + e);
		}
		add_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent add_user = new Intent(RecommendationActivity.this,
						AddUpdateRecActivity.class);
				add_user.putExtra("called", "add");
				add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
						| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(add_user);
				finish();
			}
		});

	}

	public void Set_Referash_Data() {
		recommendation_data.clear();
		db = new DatabaseHandler(this);
		ArrayList<DataEntry> recommendation_array_from_db = db.Get_Recommendations();

		for (int i = 0; i < recommendation_array_from_db.size(); i++) {

			int tidno = recommendation_array_from_db.get(i).getId();
			String weight = recommendation_array_from_db.get(i).getWeight();
			String distance = recommendation_array_from_db.get(i).getDistance();
			String sleepmin = recommendation_array_from_db.get(i).getSleepmin();
			DataEntry cnt = new DataEntry();
			cnt.setId(tidno);
			cnt.setWeight(weight);
			cnt.setSleepmin(sleepmin);
			cnt.setDistance(distance);

			recommendation_data.add(cnt);
		}
		db.close();
		cAdapter = new Recommendation_Adapter(RecommendationActivity.this,
				R.layout.activity_recommendations, recommendation_data);
		Recommendation_listview.setAdapter(cAdapter);
		cAdapter.notifyDataSetChanged();
	}

	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Set_Referash_Data();

	}

	public class Recommendation_Adapter extends ArrayAdapter<DataEntry> {
		Activity activity;
		int layoutResourceId;
		DataEntry user;
		ArrayList<DataEntry> data = new ArrayList<DataEntry>();

		public Recommendation_Adapter(Activity act, int layoutResourceId,
				ArrayList<DataEntry> data) {
			super(act, layoutResourceId, data);
			this.layoutResourceId = layoutResourceId;
			this.activity = act;
			this.data = data;
			notifyDataSetChanged();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			UserHolder holder = null;

			if (row == null) {
				LayoutInflater inflater = LayoutInflater.from(activity);

				row = inflater.inflate(layoutResourceId, parent, false);
				holder = new UserHolder();
				holder.weight = (TextView) row
						.findViewById(R.id.user_weight_txt);
				holder.sleepmin = (TextView) row
						.findViewById(R.id.user_sleepmin_txt);
				holder.distance = (TextView) row
						.findViewById(R.id.user_distance_txt);
				holder.edit = (Button) row.findViewById(R.id.btn_update);
				holder.delete = (Button) row.findViewById(R.id.btn_delete);
				row.setTag(holder);
			} else {
				holder = (UserHolder) row.getTag();
			}
			user = data.get(position);
			holder.edit.setTag(user.getId());
			holder.delete.setTag(user.getId());
			holder.weight.setText(user.getWeight());
			holder.sleepmin.setText(user.getSleepmin());
			holder.distance.setText(user.getDistance());

			holder.edit.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i("Edit Button Clicked", "**********");

					Intent update_user = new Intent(activity,
							AddUpdateRecActivity.class);
					update_user.putExtra("called", "update");
					update_user.putExtra("RECOMMENDATION_ID", v.getTag().toString());
					activity.startActivity(update_user);

				}
			});
			holder.delete.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(final View v) {
					// TODO Auto-generated method stub

					// show a message while loader is loading

					AlertDialog.Builder adb = new AlertDialog.Builder(activity);
					adb.setTitle("Delete?");
					adb.setMessage("Are you sure you want to delete ");
					final int user_id = Integer.parseInt(v.getTag().toString());
					adb.setNegativeButton("Cancel", null);
					adb.setPositiveButton("Ok",
							new AlertDialog.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// MyDataObject.remove(positionToRemove);
									DatabaseHandler dBHandler = new DatabaseHandler(
											activity.getApplicationContext());
									dBHandler.Delete_Recommendation(user_id);
									RecommendationActivity.this.onResume();

								}
							});
					adb.show();
				}

			});
			return row;

		}

		class UserHolder {
			TextView weight;
			TextView sleepmin;
			TextView distance;
			Button edit;
			Button delete;
		}

	}

}
