package com.mss.livesmart;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeartRateActivity extends Activity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate);
        
        Button btnClose = (Button) findViewById(R.id.btnCloseHeartRateView);
        btnClose.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                //Closing SecondScreen Activity
                finish();
            }
        });
	}
}
