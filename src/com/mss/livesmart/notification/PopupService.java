package com.mss.livesmart.notification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PopupService extends Service {
	private static final String TAG = "Test";
	private PopupWindow pw;

	@Override
	public void onCreate() {
		Log.i(TAG, "onCreate");
		super.onCreate();
		pw = new PopupWindow(getApplicationContext());
		try {
			Thread.sleep(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.i(TAG, "onStart");
		String str=intent.getStringExtra("data");
		pw.showPopup(str);

	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy");
		pw.removePopup();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
