package com.mss.livesmart;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;

import android.support.v4.app.Fragment; 
import android.graphics.Color;
import android.os.Bundle; 
import android.widget.CheckBox;
import android.widget.LinearLayout; 
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class HealthHistoryActivityDemoPerson1 extends Fragment{
    
    private CheckBox cbxSteps, cbxSleep, cbxHeartRate;
    private LinearLayout graphDisplayArea;
    LineGraphView graphView;
    GraphViewSeries stepsSeries, sleepSeries, heartRateSeries;
    
    public void onCreate(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_health_history_person_1,
				container, false);
 
 
        graphDisplayArea = (LinearLayout) view.findViewById(R.id.graphActivity);
        
        cbxSteps = (CheckBox) view.findViewById(R.id.cbxSteps);
        cbxSteps.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                //is cbxSteps checked?
                if (((CheckBox) v).isChecked()) {
                    graphView.addSeries(stepsSeries); 
                    //graphView.setManualYAxisBounds(2000, 0);
                } else {
                    graphView.removeSeries(stepsSeries);
                }       
            }
        });
        
        cbxSleep = (CheckBox) view.findViewById(R.id.cbxSleep);
        cbxSleep.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                //is cbxSteps checked?
                if (((CheckBox) v).isChecked()) {
                    graphView.addSeries(sleepSeries);  
                    //graphView.setManualYAxisBounds(800, 0);
                } else {
                    graphView.removeSeries(sleepSeries);
                }       
            }
        });
        
        cbxHeartRate = (CheckBox) view.findViewById(R.id.cbxHeartRate);
        cbxHeartRate.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                //is cbxSteps checked?
                if (((CheckBox) v).isChecked()) {
                    graphView.addSeries(heartRateSeries);  
                    //graphView.setManualYAxisBounds(100, 0);
                } else {
                    graphView.removeSeries(heartRateSeries);
                }       
            }
        });
        
        // init example steps data
        stepsSeries = new GraphViewSeries("Steps", null, new GraphViewData[] {
              
              new GraphViewData(1.0, 500.0d)
              , new GraphViewData(2.0, 400.0d)
              , new GraphViewData(3.0, 0.0d)
              , new GraphViewData(4.0, 1800.0d)
              , new GraphViewData(5.0, 1500.0d)
              , new GraphViewData(6.0, 1800.0d)
              , new GraphViewData(7.0, 1800.0d)
              , new GraphViewData(8.0, 1400.0d)
              , new GraphViewData(9.0, 1400.0d)
              , new GraphViewData(10.0, 1300.0d)
              , new GraphViewData(11.0, 1300.0d)
              , new GraphViewData(12.0, 1200.0d)
              , new GraphViewData(13.0, 1000.0d)
              , new GraphViewData(14.0, 1000.0d)
              , new GraphViewData(15.0, 800.0d)
        });
        GraphViewSeriesStyle sleepStyle = new GraphViewSeriesStyle(Color.GREEN, 2);
        // init example sleeps data
        sleepSeries = new GraphViewSeries("Sleep minutes", sleepStyle, new GraphViewData[] {
              
              new GraphViewData(1, 300)
              , new GraphViewData(2, 400)
              , new GraphViewData(3, 240)
              , new GraphViewData(4, 610)
              , new GraphViewData(5, 600)
              , new GraphViewData(6, 600)
              , new GraphViewData(7, 200)
              , new GraphViewData(8, 400)
              , new GraphViewData(9, 300)
              , new GraphViewData(10, 310)
              , new GraphViewData(11, 320)
              , new GraphViewData(12, 600)
              , new GraphViewData(13, 400)
              , new GraphViewData(14, 300)
              , new GraphViewData(15, 320)
        });
        GraphViewSeriesStyle heartRateStyle = new GraphViewSeriesStyle(Color.RED, 2);
        heartRateSeries = new GraphViewSeries("Heart rate", heartRateStyle, new GraphViewData[] {
                
                new GraphViewData(1, 66)
                , new GraphViewData(2, 86)
                , new GraphViewData(3, 70)
                , new GraphViewData(4, 70)
                , new GraphViewData(5, 60)
                , new GraphViewData(6, 69)
                , new GraphViewData(7, 80)
                , new GraphViewData(8, 60)
                , new GraphViewData(9, 70)
                , new GraphViewData(10, 80)
                , new GraphViewData(11, 90)
                , new GraphViewData(12, 70)
                , new GraphViewData(13, 64)
                , new GraphViewData(14, 60)
                , new GraphViewData(15, 66)
          });
        graphView = new LineGraphView(this.getActivity(), " ");
        
        
        GraphView anotherGraphView = new BarGraphView(this.getActivity(), "");       
        anotherGraphView.addSeries(sleepSeries);
        graphView.addSeries(stepsSeries); // data
        
        
        //graphView.setManualYAxisBounds(2000, 0);
        //graphView.getGraphViewStyle().setNumVerticalLabels(3);
        graphView.getGraphViewStyle().setNumHorizontalLabels(1);
        
        //graphView.getGraphViewStyle().setVerticalLabelsWidth(300);
        graphView.setHorizontalLabels(new String[] {"Mar 1", "Mar 15"});
        // set view port, start=2, size=40
        //graphView.setViewPort(1.0d, 15.0d);
        graphView.setScrollable(true);
        // optional - activate scaling / zooming
        graphView.setScalable(true);
        graphView.setShowLegend(true);
        graphView.setLegendAlign(LegendAlign.TOP);
        graphView.setLegendWidth(250);
        graphView.setDrawDataPoints(true);
        graphView.setDataPointsRadius(8.0f);
        graphView.setDrawBackground(true);
        graphView.setCustomLabelFormatter(new CustomLabelFormatter() {
            
            @Override
            public String formatLabel(double value, boolean isValueX) {
                // TODO Auto-generated method stub
                if(isValueX) {
                    return "" + (int)value;
                }
                return null;
            }
        });
        
        graphDisplayArea.addView(graphView);        
    }
     

}
