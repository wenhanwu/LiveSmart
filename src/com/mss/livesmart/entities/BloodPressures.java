package com.mss.livesmart.entities;

public class BloodPressures {

	private int systolic;
	private int diastolic;
	private String date;
	private String time;

	public BloodPressures(){
		
	}
	
	public BloodPressures(int systolic, int diastolic, String date, String time) {
		super();
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.time = time;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
