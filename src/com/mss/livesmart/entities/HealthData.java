package com.mss.livesmart.entities;

import java.util.ArrayList;
import java.util.List;

public class HealthData {
	private UserInfo userinfo;
	private ArrayList<Activities> activities;
	private ArrayList<BloodPressures> bloodPressures;
	private ArrayList<HeartBeats> heartBeats;
	private ArrayList<Sleep> sleep;

	public HealthData(UserInfo userinfo, ArrayList<Activities> activities,
			ArrayList<BloodPressures> bloodPressures,
			ArrayList<HeartBeats> heartBeats, ArrayList<Sleep> sleep) {
		super();
		this.userinfo = userinfo;
		this.activities = activities;
		this.bloodPressures = bloodPressures;
		this.heartBeats = heartBeats;
		this.sleep = sleep;
	}

	public ArrayList<Sleep> getSleep() {
		return sleep;
	} 

	public void setSleep(ArrayList<Sleep> sleep) {
		this.sleep = sleep;
	}

	public ArrayList<HeartBeats> getHeartBeats() {
		return heartBeats;
	}

	public void setHeartBeats(ArrayList<HeartBeats> heartBeats) {
		this.heartBeats = heartBeats;
	}

	public List<BloodPressures> getBloodPressures() {
		return bloodPressures;
	}

	public void setBloodPressures(ArrayList<BloodPressures> bloodPressures) {
		this.bloodPressures = bloodPressures;
	}


	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public List<Activities> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activities> activities) {
		this.activities = activities;
	}
}