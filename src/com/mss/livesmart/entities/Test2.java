package com.mss.livesmart.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test2 {
	public static void main(String[] args) {
		toJson();
		toObject();
	}

	public static void toJson() {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sDateFormat.format(new java.util.Date());

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		String curTime = timeFormat.format(new java.util.Date());

		HealthData healthData = new HealthData();
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(11);
		userInfo.setGender("male");
		userInfo.setCardio(true);
		userInfo.setDiabetes(true);
		userInfo.setHypertension(true);
		userInfo.setInsomnia(true);

		Weight w0 = new Weight();
		w0.setDate(curDate);
		w0.setValue(180);
		Weight w1 = new Weight();
		w1.setDate(curDate);
		w1.setValue(172);

		List<Weight> weightList = new ArrayList<Weight>();
		weightList.add(w0);
		weightList.add(w1);

		userInfo.setWeight(weightList);
		healthData.setUserinfo(userInfo);

		List<Activities> activities = new ArrayList<Activities>();
		Activities activity0 = new Activities();
		activity0.setDistance(999);
		activity0.setDuration(888);
		activity0.setStartTime(curTime);
		activity0.setSteps(1000);
		activity0.setDate(curDate);

		Activities activity1 = new Activities();
		activity1.setDistance(777);
		activity1.setDuration(666);
		activity1.setStartTime(curTime);
		activity1.setSteps(2000);
		activity1.setDate(curDate);

		activities.add(activity0);
		activities.add(activity1);
		healthData.setActivities(activities);
		Gson gson = new GsonBuilder().create();
		String result = gson.toJson(healthData);
		System.out.println(result);
	}

	public static String toObject() {
		String json = "{'userinfo':{'age':45,'gender':'male','height':168,'weight':[{'value':65.3,'date':'2012-04-24'},{'value':65.3,'date':'2012-04-17'},{'value':65.3,'date':'2012-03-24'}],'hypertension':true,'diabetes':true,'insomnia':true,'cardio':true},'activities':[{'distance':500,'duration':7.3,'date':'2012-04-24','startTime':'18:20:42Z','steps':800},{'distance':1500,'duration':140,'date':'2012-04-17','startTime':'','steps':1700},{'distance':12500,'duration':1430,'date':'2012-03-24','startTime':'','steps':49300}],'sleep':[{'efficiency':4,'date':'2012-04-24','startTime':'18:25:43Z','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541},{'efficiency':4,'date':'2012-04-17','startTime':'','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541},{'efficiency':4,'date':'2012-03-24','startTime':'','minutesAsleep':453,'minutesAwake':34,'awakeningsCount':8,'timeInBed':541}],'heartBeats':[{'count':56,'date':'2012-04-24','time':'18:23:43Z'},{'count':60,'date':'2012-04-17','time':''},{'count':59,'date':'2012-03-24','time':''}],'bloodPressures':[{'systolic':100,'diastolic':71,'date':'2012-04-23','time':'18:23:43Z'},{'systolic':100,'diastolic':71,'date':'2012-04-17','time':''},{'systolic':100,'diastolic':71,'date':'2012-03-24','time':''}]}";
		Gson gson = new Gson();
		HealthData hd = gson.fromJson(json, HealthData.class);
		String rtn="";
		rtn+=(hd.getActivities().size());
		rtn+=("\nuserinfo->weight£º" + 			hd.getUserinfo().getWeight().get(0).getValue());
		rtn+=("\nGender£º" + 						hd.getUserinfo().getGender());
		rtn+=("\nDistance£º" + 					hd.getActivities().get(0).getDistance());
		rtn+=("\nHeart Beat count£º" + 			hd.getHeartBeats().get(0).getCount());
		rtn+=("\nBlood Pressures Diastolic£º" + 	hd.getBloodPressures().get(0).getDiastolic());
		rtn+=("\nEfficiency£º" + 					hd.getSleep().get(0).getEfficiency());
		return rtn;
	}
}