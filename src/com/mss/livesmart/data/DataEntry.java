package com.mss.livesmart.data;

public class DataEntry {

	// private variables
	public int id;
	public String weight;
	public String distance;
	public String sleepmin;

	public DataEntry() {
	}

	// constructor
	public DataEntry(int id, String weight, String distance, String sleepmin) {
		this.id = id;
		this.weight = weight;
		this.distance = distance;
		this.sleepmin = sleepmin;

	}

	// constructor
	public DataEntry(String weight, String distance, String sleepmin) {
		this.weight = weight;
		this.distance = distance;
		this.sleepmin = sleepmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getSleepmin() {
		return sleepmin;
	}

	public void setSleepmin(String sleepmin) {
		this.sleepmin = sleepmin;
	}
 

}