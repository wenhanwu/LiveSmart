package com.mss.livesmart.sampledata;

import java.util.ArrayList;
import com.mss.livesmart.entities.Recommendation;
import com.mss.livesmart.entities.RecommendationData;

public class SampleRecommendationData {

	// This contains all the recommendation data in a list structure.
	private static ArrayList<RecommendationData> recommendationDataBase;

	public static void init() {
		recommendationDataBase = new ArrayList<RecommendationData>();
	}

	public static ArrayList<RecommendationData> getRecommendationDataBase() {
		return recommendationDataBase;
	}

	public static void setRecommendationDataBase(
			ArrayList<RecommendationData> recommendationDataBase) {
		SampleRecommendationData.recommendationDataBase = recommendationDataBase;
	}

	public static void buildSampleData() {
		init();
	}

	public static void addSampleRecommendationData(int id,
			String recommendation, String url, int severity) {
	}
	public static void addSampleRecommendationData(RecommendationData rData) {
		recommendationDataBase.add(rData);
	}
}
