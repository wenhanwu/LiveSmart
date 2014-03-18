package com.mss.livesmart.entities;

import java.util.List;

public class HealthData {
	private UserInfo userinfo;
	private List<Activities> activities;
	private List<Sleep> sleep;
	private List<HeartBeats> heartBeats;
	private List<BloodPressures> bloodPressures;

	public List<Sleep> getSleep() {
		return sleep;
	}

	public void setSleep(List<Sleep> sleep) {
		this.sleep = sleep;
	}

	public List<HeartBeats> getHeartBeats() {
		return heartBeats;
	}

	public void setHeartBeats(List<HeartBeats> heartBeats) {
		this.heartBeats = heartBeats;
	}

	public List<BloodPressures> getBloodPressures() {
		return bloodPressures;
	}

	public void setBloodPressures(List<BloodPressures> bloodPressures) {
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

	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}
}