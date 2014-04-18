package com.mss.livesmart;

import java.util.ArrayList;
import java.util.Collections;

import com.mss.livesmart.sampledata.SampleRecommendationData;
import com.mss.livesmart.utils.DataProcessor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MessageCenterActivity extends Activity {

	Bundle bundle;
	ArrayList<Response> messageArray;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message_center);

		messageArray = new ArrayList<Response>();
		messageArray.add(new Response(4, DataProcessor.getAllRecom(SampleRecommendationData.getRecommendationDataBase()), "www.google.com"));

		// show old msg, before new ones are added
		refreshMessageList();

		// get the new messages if any
		bundle = getIntent().getExtras();
		if (bundle != null) {
			Object[] oa = (Object[]) bundle.getSerializable("json");
			ArrayList<Response> newMsg = new ArrayList<Response>();
			for (int i = 0; i < oa.length; i++) {
				newMsg.add((Response) oa[i]);
			}

			// show dialog of new msg
			displayNewMessageDialog(newMsg);

		}
	}

	// Refresh list view to show content of messageArray
	private void refreshMessageList() {
		// display all messages
		Collections.reverse(messageArray);
		ArrayAdapter<Response> adapter = new ArrayAdapter<Response>(this,
				android.R.layout.simple_list_item_1, messageArray);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
	}

	// Display dialog of new messages
	private void displayNewMessageDialog(final ArrayList<Response> messages) {

		StringBuilder message = new StringBuilder();
		for (int i = 0; i < messages.size(); i++) {
			message.append(messages.get(i).getRecommendation() + "\n");
		}

		// add a dialog and set message
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		String caption = messages.size() + " New Recommendation"
				+ (messages.size() > 1 ? "s" : "") + "!";
		alertDialogBuilder.setTitle(caption);
		alertDialogBuilder.setMessage(message.toString()).setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// if "OK" is clicked, close the dialog window
						dialog.cancel();

						// add new msg to old msg list
						for (int i = 0; i < messages.size(); i++) {
							messageArray.add(messages.get(i));
						}
						// refresh list view, now it will show the newly added
						// messages
						refreshMessageList();
					}
				});

		// create and show the alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();

	}

}
