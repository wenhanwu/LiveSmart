package com.mss.livesmart;

import java.sql.Date;
import java.sql.Timestamp;

/*
 * class for health data
 * used for inserting and querying data
 */
public class HealthDataEntry {

	private Timestamp timestamp;

	// activity entry
	private int distance; // distance in meter
	private double duration;// duration in minutes or hours?
	private int steps;

	// sleep entry
	private int efficiency;
	private Date sleepStart;
	private int minutesAsleep;
	private int minutesAwake;
	private int awakeningsCount;
	private int timeInBed; // in minutes

	// heart rate entry
	private int count;

	// blood pressure entry
	private int systolic;
	private int diastolic;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}

	public Date getSleepStart() {
		return sleepStart;
	}

	public void setSleepStart(Date sleepStart) {
		this.sleepStart = sleepStart;
	}

	public int getMinutesAsleep() {
		return minutesAsleep;
	}

	public void setMinutesAsleep(int minutesAsleep) {
		this.minutesAsleep = minutesAsleep;
	}

	public int getMinutesAwake() {
		return minutesAwake;
	}

	public void setMinutesAwake(int minutesAwake) {
		this.minutesAwake = minutesAwake;
	}

	public int getAwakeningsCount() {
		return awakeningsCount;
	}

	public void setAwakeningsCount(int awakeningsCount) {
		this.awakeningsCount = awakeningsCount;
	}

	public int getTimeInBed() {
		return timeInBed;
	}

	public void setTimeInBed(int timeInBed) {
		this.timeInBed = timeInBed;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

}
