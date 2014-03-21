package com.mss.livesmart.entities;

import java.util.Date;

public class Activities {
	private int distance;
	private double duration;
	private String date;
	private String startTime;
	private int steps;

	public Activities() {

	}

	public Activities(int distance, double duration, String date,
			String startTime, int steps) {
		super();
		this.distance = distance;
		this.duration = duration;
		this.date = date;
		this.startTime = startTime;
		this.steps = steps;
	}

	public Activities(int distance, double duration, int steps) {
		this.distance = distance;
		this.duration = duration;
		this.steps = steps;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

}