package com.mss.livesmart.sampledata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mss.livesmart.GraphViewData;
import com.mss.livesmart.entities.Activities;
import com.mss.livesmart.entities.BloodPressures;
import com.mss.livesmart.entities.HealthData;
import com.mss.livesmart.entities.HeartBeats;
import com.mss.livesmart.entities.Sleep;
import com.mss.livesmart.entities.Weight;
import com.mss.livesmart.utils.JsonConvertor;

public class SampleHealthData {

	// This contains all the health data in a list structure.
	private static HealthData healthData;
	private static HealthData healthData1;
	private static HealthData healthData2;
	private static HealthData healthData3;

	public static HealthData getHealthData1() {
		return healthData1;
	}

	public static void setHealthData1(HealthData healthData1) {
		SampleHealthData.healthData1 = healthData1;
	}

	public static HealthData getHealthData2() {
		return healthData2;
	}

	public static void setHealthData2(HealthData healthData2) {
		SampleHealthData.healthData2 = healthData2;
	}

	public static HealthData getHealthData3() {
		return healthData3;
	}

	public static void setHealthData3(HealthData healthData3) {
		SampleHealthData.healthData3 = healthData3;
	}

	public static HealthData getHealthData() {
		return healthData;
	}

	public static void setHealthData(HealthData healthData) {
		SampleHealthData.healthData = healthData;
	}

	public static void init() {
		buildSampleUserInfo();
		ArrayList<Activities> activities = new ArrayList<Activities>();

		ArrayList<BloodPressures> bpressures = new ArrayList<BloodPressures>();

		ArrayList<HeartBeats> hBeats = new ArrayList<HeartBeats>();

		ArrayList<Sleep> sleeps = new ArrayList<Sleep>();
		healthData = new HealthData(CurUserInfo.getUserInfo(), activities,
				bpressures, hBeats, sleeps);

		healthData1 = JsonConvertor.SampleJsonToHealthDataObj(SampleJson
				.getRec1());
		healthData2 = JsonConvertor.SampleJsonToHealthDataObj(SampleJson
				.getRec2());
		healthData3 = JsonConvertor.SampleJsonToHealthDataObj(SampleJson
				.getRec3());
	}

	public static void buildSampleData() {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CurStatus.setCurDate(sDateFormat.format(new java.util.Date()));

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		CurStatus.setCurTime(timeFormat.format(new java.util.Date()));
		init();
		buildSampleHealthData();
	}

	public static void buildSampleUserInfo() {

		if (CurStatus.getTimeInMainPage() == 0) {
			CurUserInfo.getUserInfo().setAge(11);
			CurUserInfo.getUserInfo().setGender("male");
			CurUserInfo.getUserInfo().setCardio(true);
			CurUserInfo.getUserInfo().setDiabetes(true);
			CurUserInfo.getUserInfo().setHypertension(true);
			CurUserInfo.getUserInfo().setInsomnia(true);
			ArrayList<Weight> weights = new ArrayList<Weight>();
			CurUserInfo.getUserInfo().setWeight(weights);
			addSampleWeight(66, CurStatus.getCurDate());
		}
	}

	public static void buildSampleHealthData() {

		addSampleHealthData();

		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(healthData);
		Log.d("1111", result);
	}

	// This function is to add sample data to the health data lists
	public static void addSampleHealthData() {

		// add blood pressures week 1
		addSampleBloodPressures(66, 90, CurStatus.getCurDate());
		addSampleBloodPressures(68, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 96, CurStatus.getCurDate());
		addSampleBloodPressures(72, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 90, CurStatus.getCurDate());
		addSampleBloodPressures(68, 88, CurStatus.getCurDate());
		addSampleBloodPressures(70, 88, CurStatus.getCurDate());
		addSampleBloodPressures(66, 96, CurStatus.getCurDate());
		addSampleBloodPressures(70, 94, CurStatus.getCurDate());
		addSampleBloodPressures(72, 96, CurStatus.getCurDate());
		addSampleBloodPressures(74, 96, CurStatus.getCurDate());
		addSampleBloodPressures(78, 98, CurStatus.getCurDate());
		// add blood pressures week 2
		addSampleBloodPressures(66, 80, CurStatus.getCurDate());
		addSampleBloodPressures(68, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 96, CurStatus.getCurDate());
		addSampleBloodPressures(72, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 90, CurStatus.getCurDate());
		addSampleBloodPressures(68, 88, CurStatus.getCurDate());
		addSampleBloodPressures(70, 88, CurStatus.getCurDate());
		addSampleBloodPressures(66, 96, CurStatus.getCurDate());
		addSampleBloodPressures(70, 94, CurStatus.getCurDate());
		addSampleBloodPressures(72, 96, CurStatus.getCurDate());
		addSampleBloodPressures(74, 96, CurStatus.getCurDate());
		addSampleBloodPressures(78, 90, CurStatus.getCurDate());
		// add blood pressures week 3
		addSampleBloodPressures(66, 90, CurStatus.getCurDate());
		addSampleBloodPressures(68, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 92, CurStatus.getCurDate());
		addSampleBloodPressures(68, 96, CurStatus.getCurDate());
		addSampleBloodPressures(72, 94, CurStatus.getCurDate());
		addSampleBloodPressures(70, 90, CurStatus.getCurDate());
		addSampleBloodPressures(68, 88, CurStatus.getCurDate());
		addSampleBloodPressures(70, 88, CurStatus.getCurDate());
		addSampleBloodPressures(66, 96, CurStatus.getCurDate());
		addSampleBloodPressures(70, 94, CurStatus.getCurDate());
		addSampleBloodPressures(72, 96, CurStatus.getCurDate());
		addSampleBloodPressures(74, 96, CurStatus.getCurDate());
		addSampleBloodPressures(78, 100, CurStatus.getCurDate());
		// add sleep data week 1
		addSampleSleep(480, CurStatus.getCurDate());
		addSampleSleep(450, CurStatus.getCurDate());
		addSampleSleep(510, CurStatus.getCurDate());
		addSampleSleep(480, CurStatus.getCurDate());
		addSampleSleep(360, CurStatus.getCurDate());
		addSampleSleep(240, CurStatus.getCurDate());
		addSampleSleep(210, CurStatus.getCurDate());
		// add sleep data week 2
		addSampleSleep(450, CurStatus.getCurDate());
		addSampleSleep(450, CurStatus.getCurDate());
		addSampleSleep(510, CurStatus.getCurDate());
		addSampleSleep(480, CurStatus.getCurDate());
		addSampleSleep(360, CurStatus.getCurDate());
		addSampleSleep(240, CurStatus.getCurDate());
		addSampleSleep(210, CurStatus.getCurDate());
		// add sleep data week 3
		addSampleSleep(400, CurStatus.getCurDate());
		addSampleSleep(450, CurStatus.getCurDate());
		addSampleSleep(510, CurStatus.getCurDate());
		addSampleSleep(480, CurStatus.getCurDate());
		addSampleSleep(360, CurStatus.getCurDate());
		addSampleSleep(240, CurStatus.getCurDate());
		addSampleSleep(210, CurStatus.getCurDate());

		// add step data week 1
		addSampleActivities(1500, CurStatus.getCurDate());
		addSampleActivities(1200, CurStatus.getCurDate());
		addSampleActivities(1700, CurStatus.getCurDate());
		addSampleActivities(1600, CurStatus.getCurDate());
		addSampleActivities(1500, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
		// add step data week 2
		addSampleActivities(1200, CurStatus.getCurDate());
		addSampleActivities(1200, CurStatus.getCurDate());
		addSampleActivities(1700, CurStatus.getCurDate());
		addSampleActivities(1600, CurStatus.getCurDate());
		addSampleActivities(1500, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
		// add step data week 3
		addSampleActivities(1500, CurStatus.getCurDate());
		addSampleActivities(1700, CurStatus.getCurDate());
		addSampleActivities(1700, CurStatus.getCurDate());
		addSampleActivities(1600, CurStatus.getCurDate());
		addSampleActivities(1500, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
		addSampleActivities(1400, CurStatus.getCurDate());
	}

	public static String SampleHealthDataToJson() {
		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(healthData);
		Log.d("1111", result);
		return result;
	}

	public static void addSampleActivities(int duration, String date) {
		Activities activity = new Activities();
		activity.setDuration(duration);
		activity.setDate(date);

		healthData.getActivities().add(activity);
	}

	public static void addSampleBloodPressures(int diastolic, int systolic,
			String date) {
		BloodPressures bP = new BloodPressures();
		bP.setDate(date);
		bP.setDiastolic(diastolic);
		bP.setSystolic(systolic);
		healthData.getBloodPressures().add(bP);
	}

	public static void addSampleHeartBeats(int heartBeat, String date) {
		HeartBeats hb = new HeartBeats();
		hb.setDate(date);
		hb.setCount(heartBeat);

		healthData.getHeartBeats().add(hb);
	}

	public static void addSampleSleep(int sleepTime, String date) {
		Sleep slp = new Sleep();
		slp.setDate(date);
		slp.setMinutesAsleep(sleepTime);

		healthData.getSleep().add(slp);
	}

	public static void addSampleWeight(int value, String date) {
		Weight wt = new Weight();
		wt.setDate(date);
		wt.setValue(value);
		CurUserInfo.getUserInfo().getWeight().add(wt);
	}

}
