package com.mss.livesmart;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class PersonalInfoActivity extends Activity{
	NumberPicker weightPicker, heightPicker;
	Spinner spinnerGender;
	SharedPreferences settings; 
	DatePicker dob;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        settings = getSharedPreferences("PersonalInfo", 0);
        
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerGender.setSelection(settings.getInt("Gender", 0));
        
        dob = (DatePicker) findViewById(R.id.dateOfBirth);
        dob.init(settings.getInt("DOByear", 2014), settings.getInt("DOBmonth", 1), settings.getInt("DOBday", 1), null);
        
        weightPicker = (NumberPicker) findViewById(R.id.weightPicker);
        weightPicker.setMaxValue(200);
        weightPicker.setMinValue(0);
        weightPicker.setValue(settings.getInt("WeightInKG", 60));
        
        heightPicker = (NumberPicker) findViewById(R.id.heightPicker);
        heightPicker.setMaxValue(220);
        heightPicker.setMinValue(0);
        heightPicker.setValue(settings.getInt("HeightInCM", 170));
        
        Button btnCancel = (Button) findViewById(R.id.buttonCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                finish();
            }
        });
        
        Button btnSave = (Button) findViewById(R.id.buttonSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
            	savePersonalInfo();
            	finish();
            }
        });
	}
	
	public void  savePersonalInfo() {
		
		SharedPreferences.Editor editor = settings.edit();				
		editor.putInt("Gender", spinnerGender.getSelectedItemPosition());
		
		editor.putInt("DOBday", dob.getDayOfMonth());
		editor.putInt("DOBmonth", dob.getMonth());
		editor.putInt("DOByear", dob.getYear());
		
		editor.putInt("WeightInKG", weightPicker.getValue());
		editor.putInt("HeightInCM", heightPicker.getValue());
		
		editor.commit();
	}

}