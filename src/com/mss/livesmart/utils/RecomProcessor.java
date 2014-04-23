package com.mss.livesmart.utils;

import com.mss.livesmart.sampledata.CurUserInfo;

//The data are currently in code. For the future improvement, we will put the data in configuration file for a better extensibility.
public class RecomProcessor {
	public static String process(String rawRecom) {
		// More data for recommendation will be considered in future development
		if (rawRecom
				.contains("blood pressure kept higher than 140 in the last month")
				&& CurUserInfo.getUserInfo().isHypertension()) {
			rawRecom += "\nBetter to take some pills or see your doctor.";
		}
		return rawRecom;
	}
}
