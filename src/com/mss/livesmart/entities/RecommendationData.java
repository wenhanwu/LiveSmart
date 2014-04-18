package com.mss.livesmart.entities;

import java.util.ArrayList;

import com.mss.livesmart.sampledata.CurUserInfo;

public class RecommendationData {

	private ArrayList<Recommendation> recommendations;

	public ArrayList<Recommendation> getRecommendations() {
		return recommendations;
	}

	public RecommendationData(ArrayList<Recommendation> recommendations) {
		super();
		this.recommendations = recommendations;
	}

	public void setRecommendations(ArrayList<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

	public String recomToString() {
		String recomStr = "{";
		for (int i = 0; i < recommendations.size(); i++) {
			recomStr += "[No. " + recommendations.get(i).getId() + "] ";
			recomStr += "[" + recommendations.get(i).getRecommendation() + "] ";
			recomStr += "[" + recommendations.get(i).getUrl() + "] ";
			recomStr += "[" + recommendations.get(i).getSeverity() + "] \n";
		}
		return recomStr;
	}

}
