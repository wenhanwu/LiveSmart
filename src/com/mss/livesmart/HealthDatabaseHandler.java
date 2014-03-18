package com.mss.livesmart;

import java.util.ArrayList;
import java.util.Date;

import com.mss.livesmart.entities.Activities;
import com.mss.livesmart.entities.BloodPressures;
import com.mss.livesmart.entities.HeartBeats;
import com.mss.livesmart.entities.Sleep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HealthDatabaseHandler extends SQLiteOpenHelper {
	
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String HEALTH_DATABASE = "health_database";

    // Table names; 4 tables in total
    private static final String ACTIVITY_TABLE = "activity_table";
    private static final String SLEEP_TABLE = "sleep_table";
    private static final String HEART_RATE_TABLE = "heart_rate_table";
    private static final String BLOOD_PRESSURE_TABLE = "blood_pressure_table";
    
    
    // key for each table
    private static final String KEY_TIMESTAMP = "timestamp";
    
    // activity table column names
    private static final String DISTANCE = "distance";
    private static final String DURATION = "duration";
    private static final String STEPS = "steps";
    
    // sleep table column names
    private static final String SLEEP_EFFICIENCY = "efficiency";
    private static final String SLEEP_START = "sleepStart";
    private static final String SLEEP_MINS = "minutesAsleep";
    private static final String AWAKE_MINS = "minutesAwake";
    private static final String AWAKE_COUNT = "awakeningsCount";
    private static final String TOTAL_SLEEP_TIME = "timeInBed";
    
    // heart rate table column name
    private static final String HEART_RATE = "heartRateCount";
    
    // blood pressure table column names
    private static final String SYSTOLIC = "systolic";
    private static final String DIASTOLIC = "diastolic";
    
    // used for database inserts and queries
    private final ArrayList<Activities> activitiesList = new ArrayList<Activities>();
    private final ArrayList<Sleep> sleepList = new ArrayList<Sleep>();
    		
	public HealthDatabaseHandler(Context context) {
		super(context, HEALTH_DATABASE, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ACTIVITY_TABLE = 
				"CREATE TABLE " + ACTIVITY_TABLE + "("
				+ KEY_TIMESTAMP + " TEXT PRIMARY KEY," 
				+ DISTANCE + " INTEGER,"
				+ DURATION + " REAL," 
				+ STEPS + " INTEGER"
				+ ")";
				
		String CREATE_SLEEP_TABLE = 
				"CREATE TABLE " + SLEEP_TABLE + "("
				+ KEY_TIMESTAMP + " TEXT PRIMARY KEY," 
				+ SLEEP_EFFICIENCY + " INTEGER,"
				+ SLEEP_START + " TEXT,"
				+ SLEEP_MINS + " INTEGER," 
				+ AWAKE_MINS + " INTEGER," 
				+ AWAKE_COUNT + " INTEGER," 
				+ TOTAL_SLEEP_TIME + " INTEGER"
				+ ")";		
		
		String CREATE_HEART_RATE_TABLE = 
				"CREATE TABLE " + HEART_RATE_TABLE + "("
				+ KEY_TIMESTAMP + " TEXT PRIMARY KEY," 
				+ HEART_RATE + " INTEGER"
				+ ")";		
		
		String CREATE_BLOOD_PRESSURE_TABLE  = 
				"CREATE TABLE " + BLOOD_PRESSURE_TABLE + "("
				+ KEY_TIMESTAMP + " TEXT PRIMARY KEY," 		
				+ SYSTOLIC + " INTEGER,"
				+ DIASTOLIC + " INTEGER"
				+ ")";
				
				
			db.execSQL(CREATE_ACTIVITY_TABLE);
			db.execSQL(CREATE_SLEEP_TABLE);
			db.execSQL(CREATE_HEART_RATE_TABLE);
			db.execSQL(CREATE_BLOOD_PRESSURE_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop the old table if existed
		db.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + SLEEP_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + HEART_RATE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + BLOOD_PRESSURE_TABLE);

		// Create the table again
		onCreate(db);

	}

	// TODO
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

	public void addActivitiesEntry(Activities activities) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_TIMESTAMP, new Date().toString());
		values.put(DISTANCE, activities.getDistance());
		values.put(DURATION, activities.getDuration());
		values.put(STEPS, activities.getSteps());

		// Inserting a row
		db.insert(ACTIVITY_TABLE, null, values);
		db.close(); // Closing database connection
	}
	
	public void addSleepEntry(Sleep sleep) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_TIMESTAMP, new Date().toString());
		values.put(SLEEP_EFFICIENCY, sleep.getEfficiency());
		values.put(SLEEP_START, sleep.getStartTime().toString());
		values.put(SLEEP_MINS, sleep.getMinutesAsleep());
		values.put(AWAKE_MINS, sleep.getMinutesAwake());
		values.put(AWAKE_COUNT, sleep.getAwakeningsCount());
		values.put(TOTAL_SLEEP_TIME, sleep.getTimeInBed());

		// Inserting a row
		db.insert(SLEEP_TABLE, null, values);
		db.close(); // Closing database connection
	}

	public void addHeartRateEntry(HeartBeats heartBeats) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_TIMESTAMP, new Date().toString());
		values.put(HEART_RATE, heartBeats.getCount());

		// Inserting a row
		db.insert(HEART_RATE_TABLE, null, values);
		db.close(); // Closing database connection
	}
	
	public void addBloodPressureEntry(BloodPressures bloodPressures) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_TIMESTAMP, new Date().toString());
		values.put(SYSTOLIC, bloodPressures.getSystolic());
		values.put(DIASTOLIC, bloodPressures.getDiastolic());

		// Inserting a row
		db.insert(BLOOD_PRESSURE_TABLE, null, values);
		db.close(); // Closing database connection
	}
	
	// TODO: modify it to take "count"
	public ArrayList<Activities> getActivities(){
		
		try {
			activitiesList.clear();

		    // Select All Query
		    String selectQuery = "SELECT  * FROM " + ACTIVITY_TABLE;

		    SQLiteDatabase db = this.getWritableDatabase();
		    
		    // A Cursor represents the result of a query and basically 
		    // points to one row of the query result.
		    Cursor cursor = db.rawQuery(selectQuery, null);

		    // looping through all rows and adding to list
		    if (cursor.moveToFirst()) {
			do {
				Activities activities = new Activities();
				String timeStamp = cursor.getString(0);
				
				activities.setDistance(Integer.parseInt(cursor.getString(1)));
				activities.setDuration(Double.parseDouble(cursor.getString(2)));
				activities.setSteps(Integer.parseInt(cursor.getString(3)));
				activities.setDate(timeStamp);
				activities.setStartTime(timeStamp);
				
			    // Adding activities to list
				activitiesList.add(activities);
			} while (cursor.moveToNext());
		    }

		    // return list
		    cursor.close();
		    db.close();
		    return activitiesList;
		} catch (Exception e) {
		    // TODO: handle exception
		    Log.e("activitiesList", "" + e);
		}

		return activitiesList;
	}
	
//	public ArrayList<Sleep> getSleep(){
//	
//		try {
//			sleepList.clear();
//
//		    // Select All Query
//		    String selectQuery = "SELECT  * FROM " + SLEEP_TABLE;
//
//		    SQLiteDatabase db = this.getWritableDatabase();
//		    
//		    // A Cursor represents the result of a query and basically 
//		    // points to one row of the query result.
//		    Cursor cursor = db.rawQuery(selectQuery, null);
//
//		    // looping through all rows and adding to list
//		    if (cursor.moveToFirst()) {
//			do {
//				Sleep sleep = new Sleep();
//				String timeStamp = cursor.getString(0);
//				
//				sleep.
//				activities.setDistance(Integer.parseInt(cursor.getString(1)));
//				activities.setDuration(Double.parseDouble(cursor.getString(2)));
//				activities.setSteps(Integer.parseInt(cursor.getString(3)));
//				sleep.setDate(timeStamp);
//				sleep.setStartTime(timeStamp);
//				
//			    // Adding sleep to list
//				sleepList.add(sleep);
//			} while (cursor.moveToNext());
//		    }
//
//		   
//		    cursor.close();
//		    db.close();
//		    return sleepList;
//		} catch (Exception e) {
//		    // TODO: handle exception
//		    Log.e("sleepList", "" + e);
//		}
//
//		return sleepList;
//	}
}
