package com.mss.livesmart.entities;

public class HeartBeats {

	private int count;
	private String date;
	private String time;

	public HeartBeats(int count, String date, String time) {
		super();
		this.count = count;
		this.date = date;
		this.time = time;
	}
	public HeartBeats() {
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
