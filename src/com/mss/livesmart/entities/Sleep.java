package com.mss.livesmart.entities;

public class Sleep {
	private int efficiency;
	private String date;
	private String startTime;
	private int minutesAsleep;
	private int minutesAwake;
	private int awakeningsCount;
	private int timeInBed;

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
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

	
}
