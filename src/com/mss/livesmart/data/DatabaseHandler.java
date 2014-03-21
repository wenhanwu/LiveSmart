//package com.mss.livesmart.data;
//
//import java.util.ArrayList;
//
//import com.mss.livesmart.entities.Activities;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//public class DatabaseHandler extends SQLiteOpenHelper {
//
//    // All Static variables
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
//
//    // Database Name
//    private static final String DATABASE_NAME = "recommendationsManager";
//
//    // Recommendations table name
//    private static final String TABLE_RECOMMENDATION = "recommendations";
//
//    // Recommendations Table Columns names
//    private static final String KEY_ID = "id";
//    private static final String KEY_WEIGHT = "weight";
//    private static final String KEY_DISTANCE = "distance";
//    private static final String KEY_SLEEPMIN = "sleepmin";
//    private final ArrayList<Activities> recommendation_list = new ArrayList<Activities>();
//
//    public DatabaseHandler(Context context) {
//	super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    // Creating Tables
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//	String CREATE_RECOMMENDATIONS_TABLE = "CREATE TABLE " + TABLE_RECOMMENDATION + "("
//		+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_WEIGHT + " TEXT,"
//		+ KEY_DISTANCE + " TEXT," + KEY_SLEEPMIN + " TEXT" + ")";
//	db.execSQL(CREATE_RECOMMENDATIONS_TABLE);
//    }
//
//    // Upgrading database
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//	// Drop older table if existed
//	db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECOMMENDATION);
//
//	// Create tables again
//	onCreate(db);
//    }
//
//    /**
//     * All CRUD(Create, Read, Update, Delete) Operations
//     */
//
//    // Adding new recommendation
//    public void Add_Recommendation(Activities recommendation) {
//	SQLiteDatabase db = this.getWritableDatabase();
//	ContentValues values = new ContentValues();
//	values.put(KEY_WEIGHT, recommendation.getDuration());  
//	values.put(KEY_DISTANCE, recommendation.getDistance());  
//	values.put(KEY_SLEEPMIN, recommendation.getSteps()); 
//	// Inserting Row
//	db.insert(TABLE_RECOMMENDATION, null, values);
//	db.close(); // Closing database connection
//    }
//
//    // Getting single recommendation
//    DataEntry Get_Recommendation(int id) {
//	SQLiteDatabase db = this.getReadableDatabase();
//
//	Cursor cursor = db.query(TABLE_RECOMMENDATION, new String[] { KEY_ID,
//		KEY_WEIGHT, KEY_DISTANCE, KEY_SLEEPMIN }, KEY_ID + "=?",
//		new String[] { String.valueOf(id) }, null, null, null, null);
//	if (cursor != null)
//	    cursor.moveToFirst();
//
//	DataEntry recommendation = new DataEntry(Integer.parseInt(cursor.getString(0)),
//		cursor.getString(1), cursor.getString(2), cursor.getString(3));
//	// return recommendation
//	cursor.close();
//	db.close();
//
//	return recommendation;
//    }
//
//    // Getting All Recommendations
//    public ArrayList<DataEntry> Get_Recommendations() {
//	try {
//	    recommendation_list.clear();
//
//	    // Select All Query
//	    String selectQuery = "SELECT  * FROM " + TABLE_RECOMMENDATION;
//
//	    SQLiteDatabase db = this.getWritableDatabase();
//	    Cursor cursor = db.rawQuery(selectQuery, null);
//
//	    // looping through all rows and adding to list
//	    if (cursor.moveToFirst()) {
//		do {
//		    DataEntry recommendation = new DataEntry();
//		    recommendation.setId(Integer.parseInt(cursor.getString(0)));
//		    recommendation.setWeight(cursor.getString(1));
//		    recommendation.setDistance(cursor.getString(2));
//		    recommendation.setSleepmin(cursor.getString(3));
//		    // Adding recommendation to list
//		    recommendation_list.add(recommendation);
//		} while (cursor.moveToNext());
//	    }
//
//	    // return recommendation list
//	    cursor.close();
//	    db.close();
//	    return recommendation_list;
//	} catch (Exception e) {
//	    // TODO: handle exception
//	    Log.e("all_recommendation", "" + e);
//	}
//
//	return recommendation_list;
//    }
//
//    // Updating single recommendation
//    public int Update_Recommendation(DataEntry recommendation) {
//	SQLiteDatabase db = this.getWritableDatabase();
//
//	ContentValues values = new ContentValues();
//	values.put(KEY_WEIGHT, recommendation.getWeight());
//	values.put(KEY_DISTANCE, recommendation.getDistance());
//	values.put(KEY_SLEEPMIN, recommendation.getSleepmin());
//
//	// updating row
//	return db.update(TABLE_RECOMMENDATION, values, KEY_ID + " = ?",
//		new String[] { String.valueOf(recommendation.getId()) });
//    }
//
//    // Deleting single recommendation
//    public void Delete_Recommendation(int id) {
//	SQLiteDatabase db = this.getWritableDatabase();
//	db.delete(TABLE_RECOMMENDATION, KEY_ID + " = ?",
//		new String[] { String.valueOf(id) });
//	db.close();
//    }
//
//    // Getting recommendations Count
//    public int Get_Total_Recommendations() {
//	String countQuery = "SELECT  * FROM " + TABLE_RECOMMENDATION;
//	SQLiteDatabase db = this.getReadableDatabase();
//	Cursor cursor = db.rawQuery(countQuery, null);
//	cursor.close();
//
//	// return count
//	return cursor.getCount();
//    }
//
//}
