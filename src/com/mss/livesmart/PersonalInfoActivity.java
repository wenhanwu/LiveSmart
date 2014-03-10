package com.mss.livesmart;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class PersonalInfoActivity extends Activity{
	NumberPicker weightPicker, heightPicker;
	Spinner spinnerGender;
	SharedPreferences settings; 
	DatePicker dob;
	CheckBox hypertensionCbx, insomniaCbx, diabetesCbx, cardioCbx;
	Resources res;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        res = getResources();
        settings = getSharedPreferences(res.getString(R.string.personal_info), 0);
        
        
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerGender.setSelection(settings.getInt(res.getString(R.string.Gender), 0));
        
        dob = (DatePicker) findViewById(R.id.dateOfBirth);
        dob.init(settings.getInt(res.getString(R.string.year_of_birth), 2014), settings.getInt(res.getString(R.string.month_of_birth), 1), settings.getInt(res.getString(R.string.day_of_birth), 1), null);
        
        weightPicker = (NumberPicker) findViewById(R.id.weightPicker);
        weightPicker.setMaxValue(200);
        weightPicker.setMinValue(0);
        weightPicker.setValue(settings.getInt(res.getString(R.string.weight_in_kilogram), 60));
        
        heightPicker = (NumberPicker) findViewById(R.id.heightPicker);
        heightPicker.setMaxValue(220);
        heightPicker.setMinValue(0);
        heightPicker.setValue(settings.getInt(res.getString(R.string.height_in_centemeter), 170));
        
        hypertensionCbx = (CheckBox) findViewById(R.id.HypertensionCbx);
        hypertensionCbx.setChecked(settings.getBoolean(res.getString(R.string.Hypertension), false));
        
        insomniaCbx = (CheckBox) findViewById(R.id.InsomniaCbx);
        insomniaCbx.setChecked(settings.getBoolean(res.getString(R.string.Insomnia), false));
        
        diabetesCbx = (CheckBox) findViewById(R.id.DiabtetesCbx);
        diabetesCbx.setChecked(settings.getBoolean(res.getString(R.string.Diabetes), false));
        
        cardioCbx = (CheckBox) findViewById(R.id.CardioCbx);
        cardioCbx.setChecked(settings.getBoolean(res.getString(R.string.Cardio), false));
        
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
		editor.putInt(res.getString(R.string.Gender), spinnerGender.getSelectedItemPosition());
		
		editor.putInt(res.getString(R.string.day_of_birth), dob.getDayOfMonth());
		editor.putInt(res.getString(R.string.month_of_birth), dob.getMonth());
		editor.putInt(res.getString(R.string.year_of_birth), dob.getYear());
		
		editor.putInt(res.getString(R.string.weight_in_kilogram), weightPicker.getValue());
		editor.putInt(res.getString(R.string.height_in_centemeter), heightPicker.getValue());
		
		editor.putBoolean(res.getString(R.string.Hypertension), hypertensionCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Insomnia), insomniaCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Cardio), cardioCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Diabetes), diabetesCbx.isChecked());
		
		editor.commit();
	}

}
