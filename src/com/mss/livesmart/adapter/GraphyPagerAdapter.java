package com.mss.livesmart.adapter;

import com.mss.livesmart.HealthHistoryActivityDemoPerson1;
import com.mss.livesmart.HealthHistoryActivityDemoPerson2;
import com.mss.livesmart.HealthHistoryActivityDemoPerson3;
import com.mss.livesmart.InputDayDataFragment;
import com.mss.livesmart.InputNightDataFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GraphyPagerAdapter extends FragmentPagerAdapter  {
	public GraphyPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// day fragment activity
			return new HealthHistoryActivityDemoPerson1();
		case 1:
			// night fragment activity
			return new HealthHistoryActivityDemoPerson2();
		case 2:
			// night fragment activity
			return new HealthHistoryActivityDemoPerson3();

		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
