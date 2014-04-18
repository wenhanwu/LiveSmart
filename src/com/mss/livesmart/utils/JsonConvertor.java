package com.mss.livesmart.utils;

import java.util.ArrayList;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mss.livesmart.entities.HealthData;
import com.mss.livesmart.entities.Recommendation;
import com.mss.livesmart.entities.RecommendationData;

public class JsonConvertor {
	public static String SampleHealthDataObjToJson(HealthData healthData) {
		Gson gson = new GsonBuilder().create();
		String healthDataJson = gson.toJson(healthData);
		return healthDataJson;
	}

	public static HealthData SampleJsonToHealthDataObj(String json) {
		Gson gson = new Gson();
		HealthData healthData = gson.fromJson(json, HealthData.class);
		String outPut = "";
		outPut += (healthData.getActivities().size());
		outPut += ("\nuserinfo->weight: " + healthData.getUserinfo()
				.getWeight().get(0).getValue());
		outPut += ("\nGender: " + healthData.getUserinfo().getGender());
		outPut += ("\nDistance: " + healthData.getActivities().get(0)
				.getDistance());
		outPut += ("\nHeart Beat count: " + healthData.getHeartBeats().get(0)
				.getCount());
		outPut += ("\nBlood Pressures Diastolic: " + healthData
				.getBloodPressures().get(0).getDiastolic());
		outPut += ("\nEfficiency: " + healthData.getSleep().get(0)
				.getMinutesAsleep());
		Log.d("JSON To Obj", outPut);
		return healthData;
	}

	public static RecommendationData JsonToRecommendationDataObj(String json) {
		Gson gson = new Gson();
		Log.d("JJJJJJJJJ", json);
		ArrayList<Recommendation> recomList = new ArrayList<Recommendation>();

		recomList = gson.fromJson(json,
				new TypeToken<ArrayList<Recommendation>>() {
				}.getType());
		RecommendationData recomData = new RecommendationData(recomList);
		String outPut = "";
		outPut += ("\n" + recomData.getRecommendations().size());
		for (int i = 0; i < recomData.getRecommendations().size(); i++) {
			outPut += ("\n-->[NO. " + i + "]\n["
					+ recomData.getRecommendations().get(i).getRecommendation()
					+ "][" + recomData.getRecommendations().get(i).getUrl()
					+ "]["
					+ recomData.getRecommendations().get(i).getSeverity() + "]<--\n\n");
		}

		Log.d("JSON To Obj", outPut);
		return recomData;
	}
}
