package com.mss.livesmart.tempwork;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.*;

import com.mss.livesmart.HealthDatabaseHandler;
import com.mss.livesmart.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mss.livesmart.HealthDatabaseHandler;
import com.mss.livesmart.entities.HealthData;
import com.mss.livesmart.sampledata.SampleHealthData;

public class Test2 {

	public static void main(String[] args) {
		toJson();
		toObject();
	}

	public static void toJson() {
		SampleHealthData.getHealthData();
		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(SampleHealthData.getHealthData());
		System.out.println(result);
	}

	public static String toObject() {
		String json = "{'userinfo':{'age':45,'gender':'male','height':168,'weight':[{'value':65.3,'date':'2012-04-24'},{'value':65.3,'date':'2012-04-17'},{'value':65.3,'date':'2012-03-24'}],'hypertension':true,'diabetes':true,'insomnia':true,'cardio':true},'activities':[{'distance':500,'duration':7.3,'date':'2012-04-24','startTime':'18:20:42Z','steps':800},{'distance':1500,'duration':140,'date':'2012-04-17','startTime':'','steps':1700},{'distance':12500,'duration':1430,'date':'2012-03-24','startTime':'','steps':49300}],'sleep':[{'efficiency':4,'date':'2012-04-24','startTime':'18:25:43Z','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541},{'efficiency':4,'date':'2012-04-17','startTime':'','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541},{'efficiency':4,'date':'2012-03-24','startTime':'','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541}],'heartBeats':[{'count':56,'date':'2012-04-24','time':'18:23:43Z'},{'count':60,'date':'2012-04-17','time':''},{'count':59,'date':'2012-03-24','time':''}],'bloodPressures':[{'systolic':100,'diastolic':71,'date':'2012-04-23','time':'18:23:43Z'},{'systolic':100,'diastolic':71,'date':'2012-04-17','time':''},{'systolic':100,'diastolic':71,'date':'2012-03-24','time':''}]}";
		Gson gson = new Gson();
		HealthData hd = gson.fromJson(json, HealthData.class);
		String rtn = "";
		rtn += (hd.getActivities().size());
		rtn += ("\nuserinfo->weight: " + hd.getUserinfo().getWeight().get(0)
				.getValue());
		rtn += ("\nGender: " + hd.getUserinfo().getGender());
		rtn += ("\nDistance: " + hd.getActivities().get(0).getDistance());
		rtn += ("\nHeart Beat count: " + hd.getHeartBeats().get(0).getCount());
		rtn += ("\nBlood Pressures Diastolic: " + hd.getBloodPressures().get(0)
				.getDiastolic());
		rtn += ("\nEfficiency: " + hd.getSleep().get(0).getEfficiency());
		return rtn;
	}

	public static String tryOBJ(Context a, SharedPreferences settings, Resources res, String response) {
		HealthData hd = new HealthData(null, null, null, null, null);
		HealthDatabaseHandler hdh = new HealthDatabaseHandler(a);
		hd.setActivities(hdh.getActivities());
		hd.setBloodPressures(hdh.getBloodPressures());
		hd.setHeartBeats(hdh.getHeartBeats());
		hd.setSleep(hdh.getSleep());

		
		settings = a.getSharedPreferences(
				res.getString(R.string.personal_info), 0);

		Log.i("in tryOBJ", "# of rows in activities table: "
				+ hdh.getActivities().size());
		String rtn = "";
		// rtn += (hd.getActivities().size());

		rtn += ("\nuserinfo->weight: " + settings.getString(res.getString(R.string.weight_in_kilogram), "40"));
		rtn += ("\nGender: " + settings.getString(res.getString(R.string.Gender), "female"));

		if (hd.getActivities().size() > 0) {
			rtn += ("\nDistance: " + hd.getActivities().get(0).getDistance());
		}

		if (hd.getHeartBeats().size() > 0) {
			rtn += ("\nHeart Beat count: " + hd.getHeartBeats().get(0)
					.getCount());
		}

		if (hd.getBloodPressures().size() > 0) {
			rtn += ("\nBlood Pressures Diastolic: " + hd.getBloodPressures()
					.get(0).getDiastolic());
		}
		if (hd.getSleep().size() > 0) {
			rtn += ("\nEfficiency: " + hd.getSleep().get(0).getEfficiency());
		}


		return rtn+"\n"+response;

	}
}