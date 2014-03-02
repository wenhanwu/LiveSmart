package com.mss.livesmart;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MessageCenterActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        
        ArrayList<String> myStringArray = new ArrayList<String>();
        myStringArray.add("First Suggestion");
        myStringArray.add("2nd Suggestion");
        myStringArray.add("3rd Suggestion");
        myStringArray.add("4th Suggestion");
        myStringArray.add("5th Suggestion");
        myStringArray.add("6th Suggestion");
        myStringArray.add("7th Suggestion");
        myStringArray.add("8th Suggestion");
        myStringArray.add("9th Suggestion");
        myStringArray.add("10th Suggestion");
        myStringArray.add("11th Suggestion");
        myStringArray.add("12th Suggestion");
        
		Bundle bundle = getIntent().getExtras();
		String newMessage = "no message";
		if(bundle != null){
			newMessage = bundle.getString("key");
		}
        
		// add a dialog and set message
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("New Recommendtion!");
		alertDialogBuilder
			.setMessage(newMessage)
			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// if "OK" is clicked, close current activity
					MessageCenterActivity.this.finish();				
				}
			}) ;
	
		// create and show the alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        
        // TODO: displays a new message window
        
        // TODO: after the message window is dismissed, add the new message to list
	}
	
	
}
