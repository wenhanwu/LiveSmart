package com.mss.livesmart.entities;

import java.util.ArrayList;

import com.mss.livesmart.sampledata.CurUserInfo;
import com.mss.livesmart.utils.RecomProcessor;

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
		String recomStr = "";
		for (int i = 0; i < recommendations.size(); i++) {
			recomStr += "[Recommendation No. " + recommendations.get(i).getId()
					+ "]\n";
			recomStr += RecomProcessor.process(recommendations.get(i)
					.getRecommendation());
			recomStr += "\n\n[Reference Url]";
			recomStr += "\n[" + recommendations.get(i).getUrl() + "] ";
			recomStr += "\n\n[Severity Level]:";
			recomStr += "[" + recommendations.get(i).getSeverity() + "]";
		}
		return recomStr;
	}

}
