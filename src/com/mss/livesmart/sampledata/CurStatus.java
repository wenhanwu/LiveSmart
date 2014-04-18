package com.mss.livesmart.sampledata;

public class CurStatus {
	private static int timeInMainPage = 0;
	private static String curDate;
	private static String curTime;

	public static int getTimeInMainPage() {
		return timeInMainPage;
	}

	public static void setTimeInMainPage(int timeInMainPage) {
		CurStatus.timeInMainPage = timeInMainPage;
	}

	public static String getCurDate() {
		return curDate;
	}

	public static void setCurDate(String curDate) {
		CurStatus.curDate = curDate;
	}

	public static String getCurTime() {
		return curTime;
	}

	public static void setCurTime(String curTime) {
		CurStatus.curTime = curTime;
	}

}
