package com.mss.livesmart;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class HealthCenterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_health_center);
		
		Button getRecommendaitons = (Button) findViewById(R.id.btnGetReco);
        getRecommendaitons.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Closing SecondScreen Activity
            	DummyEngine dummyEngine = new DummyEngine();
            	String recommendation = dummyEngine.generateRecommendation();
            	
				//Starting a new Intent and Bundle
		        Intent messageCenterScreen = new Intent(getApplicationContext(), MessageCenterActivity.class);	        
				Bundle aBundle = new Bundle();
				aBundle.putString("key", recommendation );
				messageCenterScreen.putExtras(aBundle); // attach it to the intent
				startActivity(messageCenterScreen);
		        
            	finish();
            }
        });
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.health_center, menu);
		return true;
	}
*/
}
