package com.mss.livesmart;

import java.io.File;
import java.io.FileOutputStream;

import android.content.Context;

// DummyEngine generates a recommendation
// and directs user to the message center
public class DummyEngine {
	
//	String filename = "results.txt";
//	FileOutputStream os;
//	File file = new File(filename);
	
	public String generateRecommendation(){
		String result = "You are in good health";
//		os = openFileOutput(file, Context.MODE_PRIVATE);
		
		return result;
	}

}
