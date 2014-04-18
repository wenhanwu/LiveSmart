package com.mss.livesmart.entities;

public class Recommendation {
	private int id;
	private String recommendation;
	private String url;
	private int severity;

	public int getSeverity() {
		return severity;
	}

	public Recommendation(int id, String recommendation, String url,
			int severity) {
		super();
		this.id = id;
		this.recommendation = recommendation;
		this.url = url;
		this.severity = severity;
	}

	public void setSeverity(int severity) {
		this.severity = severity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
