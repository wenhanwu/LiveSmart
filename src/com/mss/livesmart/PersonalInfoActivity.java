package com.mss.livesmart;

import com.mss.livesmart.dialogs.EditDateOfBirthDialog;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;


public class PersonalInfoActivity extends FragmentActivity implements EditDateOfBirthDialog.OnCompleteListener{
	Spinner spinnerGender;
	SharedPreferences settings; 
	CheckBox hypertensionCbx, insomniaCbx, diabetesCbx, cardioCbx;
	Resources res;
	EditText txtDOB, txtWeight, txtHeight;
	int day, month, year;
	
	public void onChangeDOBComplete(int day, int month, int year){
	    this.day = day;
	    this.month = month;
	    this.year = year;
	    	    
	    // update date of birth display
	    txtDOB.setText(getDateOfBirth());
	    
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        res = getResources();
        settings = getSharedPreferences(res.getString(R.string.personal_info), 0);
        
        day = settings.getInt(res.getString(R.string.day_of_birth), 1);
        month = settings.getInt(res.getString(R.string.month_of_birth), 1);
        year = settings.getInt(res.getString(R.string.year_of_birth), 2013);
        
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerGender.setSelection(settings.getInt(res.getString(R.string.gender_spinner_value), 0));
        
        txtDOB = (EditText) findViewById(R.id.txtDOB);
        txtDOB.setText(getDateOfBirth());
        txtDOB.setOnClickListener(new View.OnClickListener() {            
            public void onClick(View arg0) {                
                FragmentManager fm = getSupportFragmentManager();
                EditDateOfBirthDialog dialog = new EditDateOfBirthDialog();               
                dialog.show(fm, "edit_date_of_birth_dialog");
                
            }
        });
        
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        txtWeight.setText(settings.getString(res.getString(R.string.weight_in_kilogram), "60"));        
        
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtHeight.setText(settings.getString(res.getString(R.string.height_in_centemeter), "170"));
        
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
	
	public String getDateOfBirth(){
	    int adjustedMonth = month + 1;
	    String dob = "" + year + "/" + adjustedMonth + "/" + day;
	    return dob;
	}
	
	public void  savePersonalInfo() {
		
		SharedPreferences.Editor editor = settings.edit();				
		editor.putInt(res.getString(R.string.gender_spinner_value), spinnerGender.getSelectedItemPosition());
		editor.putString(res.getString(R.string.Gender), getGender(spinnerGender.getSelectedItemPosition()));
		editor.putString(res.getString(R.string.weight_in_kilogram), txtWeight.getText().toString());
		editor.putString(res.getString(R.string.height_in_centemeter), txtHeight.getText().toString());
		
        editor.putInt(res.getString(R.string.day_of_birth), day);
		editor.putInt(res.getString(R.string.month_of_birth), month);
        editor.putInt(res.getString(R.string.year_of_birth), year);
        
		editor.putBoolean(res.getString(R.string.Hypertension), hypertensionCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Insomnia), insomniaCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Cardio), cardioCbx.isChecked());
		editor.putBoolean(res.getString(R.string.Diabetes), diabetesCbx.isChecked());
		
		editor.commit();
	}
	
	public String getGender(int spinnerIndex) {
	    String gender = "Default";
	    switch(spinnerIndex){
	        case 0: gender = "Male";
	            break;
	        case 1: gender = "Female";	
	            break;
	    }
	    return gender;
	}

}
