package com.mss.livesmart;

import java.util.ArrayList;

import android.app.Activity;
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
		if(bundle != null){
			String newMessage = bundle.getString("key");
		}
        

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myStringArray);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        
        // TODO: displays a new message window
        
        // TODO: after the message window is dismissed, add the new message to list
	}
}
