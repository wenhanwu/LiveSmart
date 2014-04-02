package com.mss.livesmart.adapter;

import com.mss.livesmart.InputDayDataFragment;
import com.mss.livesmart.InputNightDataFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter  {
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// day fragment activity
			return new InputDayDataFragment();
		case 1:
			// night fragment activity
			return new InputNightDataFragment();

		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}
