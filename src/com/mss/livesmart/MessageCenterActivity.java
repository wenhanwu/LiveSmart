package com.mss.livesmart;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MessageCenterActivity extends Activity {
	
	Bundle bundle;
	String newMessage;
	ArrayList<String> messageArray;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_center);
        
        ArrayList<String> messageArray = new ArrayList<String>();
        messageArray.add("First Suggestion");
        messageArray.add("2nd Suggestion");
        messageArray.add("3rd Suggestion");
        messageArray.add("4th Suggestion");
        messageArray.add("5th Suggestion");
        messageArray.add("6th Suggestion");
        messageArray.add("7th Suggestion");
        messageArray.add("8th Suggestion");
        messageArray.add("9th Suggestion");
        messageArray.add("10th Suggestion");
        messageArray.add("11th Suggestion");
        messageArray.add("12th Suggestion");
        
		// get the new message if any
		bundle = getIntent().getExtras();
		if (bundle != null) {
			newMessage = bundle.getString("key");
			displayNewMessage(newMessage);
			messageArray.add(newMessage);
		}

		// display all messages
		Collections.reverse(messageArray);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, messageArray);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);

	}
	
	private void displayNewMessage(String message) {

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

	}

}
