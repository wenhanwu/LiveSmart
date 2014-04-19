package com.mss.livesmart.tempwork;

import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String recommendation;
	private String url;

	public Response(){
		
	}
	
	public Response(int id, String recommendation, String url){
		this.id = id;
		this.recommendation = recommendation; 
		this.url = url;
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

	@Override
	public String toString(){
		return recommendation;
	}
}
