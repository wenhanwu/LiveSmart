package com.mss.livesmart.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.http.AndroidHttpClient;

import com.google.gson.Gson;
import com.mss.livesmart.MainActivity;
import com.mss.livesmart.entities.HealthData;
import com.mss.livesmart.notification.PopupService;
import com.mss.livesmart.sampledata.CurStatus;
import com.mss.livesmart.sampledata.SampleJson;

public class RecomHandler {
public static void getRecommendation(Activity act){
	HealthData hd = JsonConvertor
			.SampleJsonToHealthDataObj(SampleJson.rec1);

	Gson g = new Gson();
	String message = g.toJson(hd);
	AndroidHttpClient hc = AndroidHttpClient.newInstance(CurStatus
			.getUrl());
	Communicator task = new Communicator(hc, 0, message, CurStatus
			.getUrl(), "");
	task.start();

	while (CurStatus.getRecomMutex() == 0) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Intent intent = new Intent(act,
			PopupService.class);
	intent.putExtra("data", CurStatus.getRecom());
	act.startService(intent);
	CurStatus.setRecomMutex(0);

}
 
}
