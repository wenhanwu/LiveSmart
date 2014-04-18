package com.mss.livesmart.sampledata;

import com.mss.livesmart.entities.UserInfo;

public class CurUserInfo {

	private static UserInfo userInfo=new UserInfo();

	public static UserInfo getUserInfo() {
		return userInfo;
	}

	public static void setUserInfo(UserInfo userInfo) {
		CurUserInfo.userInfo = userInfo;
	}
}
