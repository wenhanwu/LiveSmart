package com.mss.livesmart.sampledata;

public class CurStatus {
	private static int timeInMainPage = 0;
	private static String curDate;
	private static String curTime;
	private static String url="http://health-engine.herokuapp.com";

	private static String recom="";
	private static int recomMutex=0;
	

	public static String getRecom() {
		return recom;
	}

	public static void setRecom(String recom) {
		CurStatus.recom = recom;
	}

	public static int getRecomMutex() {
		return recomMutex;
	}

	public static void setRecomMutex(int recomMutex) {
		CurStatus.recomMutex = recomMutex;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		CurStatus.url = url;
	}

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
