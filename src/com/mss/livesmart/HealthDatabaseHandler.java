package com.mss.livesmart;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HealthDatabaseHandler extends SQLiteOpenHelper {
	
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String HEALTH_DATABASE = "health_database";

    // Table name
    private static final String HEALTH_DATA_TABLE = "health_data_table";
    
    // activity entry column names
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String DISTANCE = "distance";
    private static final String DURATION = "duration";
    private static final String STEPS = "steps";
    
    // sleep entry column names
    private static final String SLEEP_EFFICIENCY = "efficiency";
    private static final String SLEEP_START = "sleepStart";
    private static final String SLEEP_MINS = "minutesAsleep";
    private static final String AWAKE_MINS = "minutesAwake";
    private static final String AWAKE_COUNT = "awakeningsCount";
    private static final String TOTAL_SLEEP_TIME = "timeInBed";
    
    // heart rate entry column name
    private static final String HEART_RATE = "heartRateCount";
    
    // blood pressure entry column names
    private static final String SYSTOLIC = "systolic";
    private static final String DIASTOLIC = "diastolic";
    
	public HealthDatabaseHandler(Context context) {
		super(context, HEALTH_DATABASE, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_HEALTH_DATA_TABLE = 
				"CREATE TABLE " + HEALTH_DATA_TABLE + "("
				+ KEY_TIMESTAMP + " TEXT PRIMARY KEY," 
				+ DISTANCE + " INTEGER,"
				+ DURATION + " REAL," 
				+ STEPS + " INTEGER," 
				+ SLEEP_EFFICIENCY + " INTEGER,"
				+ SLEEP_START + " TEXT,"
				+ SLEEP_MINS + " INTEGER," 
				+ AWAKE_MINS + " INTEGER," 
				+ AWAKE_COUNT + " INTEGER," 
				+ TOTAL_SLEEP_TIME + " INTEGER," 
				+ HEART_RATE + " INTEGER,"
				+ SYSTOLIC + " INTEGER,"
				+ DIASTOLIC + " INTEGER"
				+ ")";
			db.execSQL(CREATE_HEALTH_DATA_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop the old table if existed
		db.execSQL("DROP TABLE IF EXISTS " + HEALTH_DATA_TABLE);

		// Create the table again
		onCreate(db);

	}

	// TODO
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

	// Adding new recommendation
	public void addHealthDataEntry(HealthDataEntry healthEntry) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_TIMESTAMP, new Date().toString());
		values.put(DISTANCE, healthEntry.getDistance());
		values.put(DURATION, healthEntry.getDuration());
		values.put(STEPS, healthEntry.getSteps());

		values.put(SLEEP_EFFICIENCY, healthEntry.getEfficiency());
		values.put(SLEEP_START, healthEntry.getSleepStart().toString());
		values.put(SLEEP_MINS, healthEntry.getMinutesAsleep());
		values.put(AWAKE_MINS, healthEntry.getMinutesAwake());
		values.put(AWAKE_COUNT, healthEntry.getAwakeningsCount());
		values.put(TOTAL_SLEEP_TIME, healthEntry.getTimeInBed());

		values.put(HEART_RATE, healthEntry.getCount());
		values.put(SYSTOLIC, healthEntry.getSystolic());
		values.put(DIASTOLIC, healthEntry.getDiastolic());

		// Inserting a row
		db.insert(HEALTH_DATA_TABLE, null, values);
		db.close(); // Closing database connection
	}
	
	
}
