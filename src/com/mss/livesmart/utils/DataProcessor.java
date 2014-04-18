package com.mss.livesmart.utils;

import java.util.ArrayList; 
import com.google.gson.Gson;
import com.mss.livesmart.entities.RecommendationData;

public class DataProcessor {
	public static String getAllRecom(ArrayList<RecommendationData> recommendationDataBase) {

		String recomStr = "";
		for (int i = 0; i < recommendationDataBase.size(); i++) {

			recomStr += "-->" + i + "<--";
			recomStr += recommendationDataBase.get(i).recomToString();

			recomStr += "*******************\n";
		}
		recomStr += "\n";
		return recomStr;
	}
}
