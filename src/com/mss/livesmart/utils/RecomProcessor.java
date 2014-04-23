package com.mss.livesmart.utils;

public class RecomProcessor {
	public static String process(String rawRecom) {
		if (rawRecom
				.contains("blood pressure kept higher than 140 in the last month")) {
			rawRecom += "\nBetter to take some pills.";
		}
		return rawRecom;
	}
}
