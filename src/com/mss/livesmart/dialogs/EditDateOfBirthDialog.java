package com.mss.livesmart.dialogs;


import com.mss.livesmart.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class EditDateOfBirthDialog extends DialogFragment{
    SharedPreferences settings;
    Resources res;
    DatePicker dob;
    EditText tv;
    int day, month, year;
    public EditDateOfBirthDialog() {
        // TODO Auto-generated constructor stub
    }

    public static interface OnCompleteListener {
        public abstract void onChangeDOBComplete(int day, int month, int year);
    }

    private OnCompleteListener dateChangeListener;

    // make sure the Activity implemented it
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.dateChangeListener = (OnCompleteListener) activity;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        res = getResources();
        settings = this.getActivity().getSharedPreferences(res.getString(R.string.personal_info), 0);
        View view = inflater.inflate(R.layout.edit_date_of_birth_dialog, container);   
        dob = (DatePicker) view.findViewById(R.id.dpDOB);
        setInitialDate(dob);
        tv = (EditText) view.findViewById(R.id.txtDOB);
        getDialog().setTitle(R.string.date_of_birth);
        addSaveBtnListenner(view);
        addCancelBtnListenner(view);        
        return view;
    }
    
    public void setInitialDate(DatePicker dob){
        dob.init(settings.getInt(res.getString(R.string.year_of_birth), 2014), settings.getInt(res.getString(R.string.month_of_birth), 1), settings.getInt(res.getString(R.string.day_of_birth), 1), null);
    }
    
    public void addSaveBtnListenner(View view){
        Button btnCancel = (Button) view.findViewById(R.id.btnSaveDOB);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //saveDateOfBirth(view);   
                // call back
                dateChangeListener.onChangeDOBComplete(dob.getDayOfMonth(), dob.getMonth(), dob.getYear());
                getDialog().dismiss();
            }
        });
    }
    
    public void saveDateOfBirth(View view){
        
        SharedPreferences.Editor editor = settings.edit();          
        editor.putInt(res.getString(R.string.day_of_birth), dob.getDayOfMonth());
        editor.putInt(res.getString(R.string.month_of_birth), dob.getMonth());
        editor.putInt(res.getString(R.string.year_of_birth), dob.getYear());
        editor.commit();        
    }
    
    public void addCancelBtnListenner(View view){
        Button btnSave = (Button) view.findViewById(R.id.btnCancel);
        btnSave.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {                
                getDialog().dismiss();
            }
        });
    }
    

}
