package com.mss.livesmart.notification;

import com.mss.livesmart.MainActivity;
import com.mss.livesmart.MessageCenterActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PopupView extends LinearLayout {
	private TextView tv;
	private Button btn_dismiss;
	private Button btn_open;
	private WindowManager wm; 

	public PopupView(Context context, String str, WindowManager wMngr) {
		super(context);
		wm = wMngr;
		this.setOrientation(1);
		
		tv = new TextView(context);
		tv.setText(str);
		tv.setTextSize(18);
		tv.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
		this.addView(tv);

		btn_dismiss = new Button(context);
		btn_dismiss.setText("Ignore");
		btn_dismiss.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        }
		});
		this.addView(btn_dismiss);
		
		btn_open = new Button(context);
		btn_open.setText("Check");
		btn_open.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        	Intent intent = new Intent(v.getContext(), MessageCenterActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	v.getContext().startActivity(intent);
	        }
		});
		this.addView(btn_open);

	}

	public void removePopup() {
		wm.removeView(this);
	}
}
