package com.mss.livesmart;

import com.mss.livesmart.data.ActivitiesActivity;
import com.mss.livesmart.entities.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import com.loopj.android.http.*;

public class MainActivity extends Activity {
	MyImageView healthCenter;
	MyImageView	messageCenter;
	MyImageView inputHealthData;
	MyImageView getRecommendations;
	MyImageView testDatabase;
	SharedPreferences settings;
	Resources res;
	
 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		res = getResources();
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
		
		inputHealthData = (MyImageView) findViewById(R.id.c_input_health_data);
		inputHealthData.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new intent
		        Intent inputHealthScreen = new Intent(getApplicationContext(), InputHealthDataActivity.class);
		        startActivity(inputHealthScreen);
			}
		});
		
		getRecommendations = (MyImageView) findViewById(R.id.c_get_recommendations);
		getRecommendations.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				
	            AsyncHttpClient client = new AsyncHttpClient();
	            //String request ="{\n    \"userinfo\": {\n        \"age\": 45,\n        \"gender\": \"male\",\n        \"height\": 168,\n        \"weight\": [\n            {\n                \"value\": 65.3,    //this is the data of current day\n                \"date\": \"2012-04-24\"\n            },\n            {\n                \"value\": 65.3,    // this should be average of last week\n                \"date\": \"2012-04-17\"    //by defult this should the last 7 days\n            },\n            {\n                \"value\": 65.3,    // this should be average of last month\n                \"date\": \"2012-03-24\"    //by defult this should the last 30 days\n            }\n        ],\n        \"hypertension\" : true,\n        \"diabetes\" : true,\n        \"insomnia\" : true,\n        \"cardio\" : true\n    },\n    \"activities\": [\n        {\n            \"distance\": 500,     //this is the data of current day\n            \"duration\": 7.3,\n            \"date\": \"2012-04-24\",\n            \"startTime\": \"18:20:42Z\",\n            \"steps\": 800\n        },\n        {\n            \"distance\": 1500,  // this is accumulation not average by last week\n            \"duration\": 140,\n            \"date\": \"2012-04-17\",\n            \"startTime\": \"\",    // timestamp should be empty\n            \"steps\": 1700\n        },\n        {\n            \"distance\": 12500, // this is accumulation not average by last month\n            \"duration\": 1430,\n            \"date\": \"2012-03-24\",\n            \"startTime\": \"\",   // timestamp should be empty\n            \"steps\": 49300\n        }\n    ],\n    \"sleep\": [\n        {\n            \"efficiency\": 4,    //this is the data of current day\n            \"date\": \"2012-04-24\",\n            \"startTime\": \"18:25:43Z\",\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        },\n        {\n            \"efficiency\": 4,   // this is the average of last week\n            \"date\": \"2012-04-17\",\n            \"startTime\": \"\",   // this should be empty\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        },\n        {\n            \"efficiency\": 4,  // this is the average of last month\n            \"date\": \"2012-03-24\",\n            \"startTime\": \"\",  // this should be empty\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        }\n    ],\n    \"heartBeats\": [\n        {\n            \"count\": 56,       //this is the data of current day\n           ,\n            \"time\": \"18:23:43Z\"\n        },\n        {\n            \"count\": 60,       //this is the average of last week\n            \"date\": \"2012-04-17\",\n            \"time\": \"\"\n        },\n        {\n            \"count\": 59,      //this is the average of last month\n            \"date\": \"2012-03-24\",\n            \"time\": \"\"\n        }\n    ],\n    \"bloodPressures\": [\n        {\n            \"systolic\": 100,         //this is the data of current day\n            \"diastolic\": 71,\n            \"date\": \"2012-04-23\",\n            \"time\": \"18:23:43Z\"\n        },\n        {\n            \"systolic\": 100,         //this is the average of last week\n            \"diastolic\": 71,\n            \"date\": \"2012-04-17\",     \n            \"time\": \"\"               // timestamp should be empty\n        },\n        {\n            \"systolic\": 100,         //this is the average of last month\n            \"diastolic\": 71,\n            \"date\": \"2012-03-24\",\n            \"time\": \"\"               // timestamp should be empty\n        }\n    ]\n}";
	            String request = "";
	            RequestParams params = new RequestParams("json", request);
	            client.post(res.getString(R.string.engine_url), params, new AsyncHttpResponseHandler() {
	                @Override
	                public void onSuccess(String response) {
	                	SharedPreferences settings; 
	            		Resources res = getResources();
	                    settings = getSharedPreferences(res.getString(R.string.personal_info), 0);
	                    
	                     
	                	String str=Test2.tryOBJ(MainActivity.this, settings, res);
	                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();	  
	                    Log.i("Output", str);
	                }
	            });
			}
		});
		testDatabase = (MyImageView) findViewById(R.id.c_test_database);
		testDatabase.setOnClickIntent(new MyImageView.OnViewClick() {
			
			@Override
			public void onClick() {				
				//Starting a new Intent
		        Intent recommendationScreen = new Intent(getApplicationContext(), ActivitiesActivity.class);
		        startActivity(recommendationScreen);
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
	            AsyncHttpClient client = new AsyncHttpClient();
	            //String request ="{\n    \"userinfo\": {\n        \"age\": 45,\n        \"gender\": \"male\",\n        \"height\": 168,\n        \"weight\": [\n            {\n                \"value\": 65.3,    //this is the data of current day\n                \"date\": \"2012-04-24\"\n            },\n            {\n                \"value\": 65.3,    // this should be average of last week\n                \"date\": \"2012-04-17\"    //by defult this should the last 7 days\n            },\n            {\n                \"value\": 65.3,    // this should be average of last month\n                \"date\": \"2012-03-24\"    //by defult this should the last 30 days\n            }\n        ],\n        \"hypertension\" : true,\n        \"diabetes\" : true,\n        \"insomnia\" : true,\n        \"cardio\" : true\n    },\n    \"activities\": [\n        {\n            \"distance\": 500,     //this is the data of current day\n            \"duration\": 7.3,\n            \"date\": \"2012-04-24\",\n            \"startTime\": \"18:20:42Z\",\n            \"steps\": 800\n        },\n        {\n            \"distance\": 1500,  // this is accumulation not average by last week\n            \"duration\": 140,\n            \"date\": \"2012-04-17\",\n            \"startTime\": \"\",    // timestamp should be empty\n            \"steps\": 1700\n        },\n        {\n            \"distance\": 12500, // this is accumulation not average by last month\n            \"duration\": 1430,\n            \"date\": \"2012-03-24\",\n            \"startTime\": \"\",   // timestamp should be empty\n            \"steps\": 49300\n        }\n    ],\n    \"sleep\": [\n        {\n            \"efficiency\": 4,    //this is the data of current day\n            \"date\": \"2012-04-24\",\n            \"startTime\": \"18:25:43Z\",\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        },\n        {\n            \"efficiency\": 4,   // this is the average of last week\n            \"date\": \"2012-04-17\",\n            \"startTime\": \"\",   // this should be empty\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        },\n        {\n            \"efficiency\": 4,  // this is the average of last month\n            \"date\": \"2012-03-24\",\n            \"startTime\": \"\",  // this should be empty\n            \"minutesAsleep\": 453,\n            \"minutesAwake\": 34,\n            \"awakeningsCount\": 8,\n            \"timeInBed\": 541\n        }\n    ],\n    \"heartBeats\": [\n        {\n            \"count\": 56,       //this is the data of current day\n           ,\n            \"time\": \"18:23:43Z\"\n        },\n        {\n            \"count\": 60,       //this is the average of last week\n            \"date\": \"2012-04-17\",\n            \"time\": \"\"\n        },\n        {\n            \"count\": 59,      //this is the average of last month\n            \"date\": \"2012-03-24\",\n            \"time\": \"\"\n        }\n    ],\n    \"bloodPressures\": [\n        {\n            \"systolic\": 100,         //this is the data of current day\n            \"diastolic\": 71,\n            \"date\": \"2012-04-23\",\n            \"time\": \"18:23:43Z\"\n        },\n        {\n            \"systolic\": 100,         //this is the average of last week\n            \"diastolic\": 71,\n            \"date\": \"2012-04-17\",     \n            \"time\": \"\"               // timestamp should be empty\n        },\n        {\n            \"systolic\": 100,         //this is the average of last month\n            \"diastolic\": 71,\n            \"date\": \"2012-03-24\",\n            \"time\": \"\"               // timestamp should be empty\n        }\n    ]\n}";
	            String request = "";
	            RequestParams params = new RequestParams("json", request);
	            client.post(res.getString(R.string.engine_url), params, new AsyncHttpResponseHandler() {
	                @Override
	                public void onSuccess(String response) {
	                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();	                    
	                }
	            });
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