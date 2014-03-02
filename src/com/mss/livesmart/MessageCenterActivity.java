package com.mss.livesmart;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MessageCenterActivity extends Activity {
	
	Bundle bundle;
	String newMessage;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        
        displayNewMessage();
        
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
       
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);  
	}
	
	private void displayNewMessage() {

		// get the message
		bundle = getIntent().getExtras();
		newMessage = "no message";
		if (bundle != null) {
			newMessage = bundle.getString("key");
		}

		// add a dialog and set message
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("New Recommendation!");
		alertDialogBuilder.setMessage(newMessage).setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// if "OK" is clicked, close the dialog window
						dialog.cancel();
					}
				});

		// create and show the alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		

		// TODO: after the message window is dismissed, add the new message to list
	}

}
