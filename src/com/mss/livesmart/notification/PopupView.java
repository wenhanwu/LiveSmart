package com.mss.livesmart.notification;

import com.mss.livesmart.MessageCenterActivity;
import com.mss.livesmart.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PopupView extends LinearLayout {
	private TextView tv;
	private Button btn_ignore;
	private Button btn_check;
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

		tv.setTextColor(Color.BLACK);
		tv.setBackgroundColor(Color.LTGRAY);
		tv.setPadding(20,20,20,20);
		tv.setBackgroundResource(R.drawable.text_view_border);  
		
		btn_ignore = new Button(context);
		btn_ignore.setText("OK");
		btn_ignore.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        }
		});
		this.addView(btn_ignore);
		
		btn_check = new Button(context);
		btn_check.setText("Check Msg Center");
		btn_check.setOnClickListener(new OnClickListener(){
	        @Override 
	        public void onClick(View v)  {
	        	removePopup();
	        	Intent intent = new Intent(v.getContext(), MessageCenterActivity.class);
	        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	        	v.getContext().startActivity(intent);
	        }
		});
		this.addView(btn_check);

	}

	public void removePopup() {
		wm.removeView(this);
	}
}
