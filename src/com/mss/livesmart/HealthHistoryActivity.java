package com.mss.livesmart;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;
import com.mss.livesmart.sampledata.SampleHealthData;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;


public class HealthHistoryActivity extends Activity{
    
    private CheckBox cbxSteps, cbxSleep, cbxHeartRate;
    private LinearLayout graphDisplayArea, graphSleep, graphBp;
    LineGraphView graphView, graphViewBp;
    BarGraphView graphViewSleep, graphViewStep;
    GraphViewSeries stepsSeries, sleepSeries, heartRateSeries, bpSystolicSeries, bpDiastolicSeries;
    TextView stepsText;
    private int currentX = 0;
    private float lastTouchEventX;
    private boolean scrollingStarted;
    private int chartWidth;
    private GraphViewData[] stepsData, sleepData, bpDiastolicData, bpSystolicData;
    final int weekly = 7;
    final int biweekly = 14;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_history);
        
        stepsData = new GraphViewData[weekly];
        
        graphDisplayArea = (LinearLayout) findViewById(R.id.graphActivity);
        graphSleep = (LinearLayout) findViewById(R.id.graphSleep);
        graphBp = (LinearLayout) findViewById(R.id.graphBp);
        
        stepsText = (TextView) findViewById(R.id.txtSteps1);
        stepsText.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                stepsText.setText("touch!");
                return false;
            }
        });
        

        graphDisplayArea.setOnTouchListener(new OnTouchListener() {            

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                
                boolean handled = false;
                if (!handled) {
                    if ((event.getAction() & MotionEvent.ACTION_DOWN) == MotionEvent.ACTION_DOWN
                            && (event.getAction() & MotionEvent.ACTION_MOVE) == 0) {
                        scrollingStarted = true;
                        handled = true;
                    }
                    if ((event.getAction() & MotionEvent.ACTION_UP) == MotionEvent.ACTION_UP) {
                        scrollingStarted = false;
                        lastTouchEventX = 0;
                        handled = true;
                    }
                    if ((event.getAction() & MotionEvent.ACTION_MOVE) == MotionEvent.ACTION_MOVE) {
                        if (scrollingStarted) {
                            if (lastTouchEventX != 0) {
                                //moveVbyTouch(event.getX());
                                TextView stepsTexts = (TextView) findViewById(R.id.txtSteps1);
                                //stepsText.setText(Double.toString(stepsData[currentX].getY()));
                                stepsTexts.setText(Float.toString(event.getX()));
                                
                            }
                            lastTouchEventX = event.getX();
                            handled = true;
                        }
                    }

                } else {
                    // currently scaling
                    scrollingStarted = false;
                    lastTouchEventX = 0;
                }
                return handled;
            }
        });
        
        cbxSteps = (CheckBox) findViewById(R.id.cbxSteps);
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
        
        cbxSleep = (CheckBox) findViewById(R.id.cbxSleep);
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
        
        cbxHeartRate = (CheckBox) findViewById(R.id.cbxHeartRate);
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
        stepsSeries = new GraphViewSeries("Steps", null, stepsData);
        GraphViewSeriesStyle sleepStyle = new GraphViewSeriesStyle(Color.GREEN, 2);
        // init example sleeps data
        sleepData = new GraphViewData[weekly];
        for(int i =0; i < weekly; i++) {
            sleepData[i] = new GraphViewData(i, SampleHealthData.getHealthData().getSleep().get(i).getMinutesAsleep()/60);
            stepsData[i] = new GraphViewData(i, SampleHealthData.getHealthData().getActivities().get(i).getDuration());
        }
       
        sleepSeries = new GraphViewSeries("Sleep minutes", sleepStyle, sleepData);
        bpSystolicData = new GraphViewData[biweekly];
        bpDiastolicData = new GraphViewData[biweekly];
        for(int i=0; i < biweekly; i++) {
            bpSystolicData[i] = new GraphViewData(i, SampleHealthData.getHealthData().getBloodPressures().get(i).getSystolic());
            bpDiastolicData[i] = new GraphViewData(i, SampleHealthData.getHealthData().getBloodPressures().get(i).getDiastolic());
            
        }
        GraphViewSeriesStyle bpStyle1 = new GraphViewSeriesStyle(Color.RED, 2);
        bpSystolicSeries = new GraphViewSeries("Systolic", bpStyle1, bpSystolicData);
        
        
        
        GraphViewSeriesStyle bpStyle2 = new GraphViewSeriesStyle(Color.YELLOW, 2);
        bpDiastolicSeries = new GraphViewSeries("Diastolic", bpStyle2, bpDiastolicData);
        
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
        graphView = new LineGraphView(this, " ");
        
        graphViewStep = new BarGraphView(this, "Steps");
        graphViewStep.addSeries(stepsSeries);
        graphViewStep.setHorizontalLabels(new String[] {"Apr 6"," ", " ", "Apr 12"});
        graphViewStep.getGraphViewStyle().setNumHorizontalLabels(4);
        graphViewStep.setManualYAxisBounds(2000, 0);
        
        graphViewSleep = new BarGraphView(this, "Sleep hours");
        graphViewSleep.addSeries(sleepSeries);
        graphViewSleep.setHorizontalLabels(new String[] {"Apr 6"," ", " ", "Apr 12"});
        graphViewSleep.getGraphViewStyle().setNumHorizontalLabels(4);
        graphViewSleep.setManualYAxisBounds(12, 0);
       
        graphViewBp = new LineGraphView(this, "Blood pressure");
        graphViewBp.addSeries(bpSystolicSeries);
        graphViewBp.addSeries(bpDiastolicSeries);
        graphViewBp.setHorizontalLabels(new String[] {"Apr 6"," ", " ", "Apr 12"});
        graphViewBp.getGraphViewStyle().setNumHorizontalLabels(4);
        graphViewBp.setManualYAxisBounds(150, 0);
        graphViewBp.setShowLegend(true);
        graphViewBp.setDrawDataPoints(true);
        graphViewBp.setLegendAlign(LegendAlign.TOP);
        graphViewBp.setLegendWidth(165);
        graphViewBp.setDataPointsRadius(4.0f);
        //graphViewBp.setDrawBackground(true);
        
        GraphView anotherGraphView = new BarGraphView(this, "");       
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
        
        graphDisplayArea.addView(graphViewStep);      
        graphSleep.addView(graphViewSleep);
        graphBp.addView(graphViewBp);
    }

}
