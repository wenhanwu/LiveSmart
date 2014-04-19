package com.mss.livesmart;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;
import com.mss.livesmart.sampledata.SampleHealthData;

import android.support.v4.app.Fragment; 
import android.graphics.Color;
import android.os.Bundle; 
import android.widget.CheckBox;
import android.widget.LinearLayout; 
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class HealthHistoryActivityDemoPerson1 extends Fragment{
    
    private CheckBox cbxSteps, cbxSleep, cbxHeartRate;
    private LinearLayout graphDisplayArea, graphSleep, graphBp;
    LineGraphView graphView, graphViewBp;
    BarGraphView graphViewSleep, graphViewStep;
    GraphViewSeries stepsSeries, sleepSeries, heartRateSeries, bpSystolicSeries, bpDiastolicSeries;
    private GraphViewData[] stepsData, sleepData, bpDiastolicData, bpSystolicData;
    final int weekly = 7;
    final int biweekly = 14;
    View view;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.activity_health_history_person_1,
				container, false);
		stepsData = new GraphViewData[weekly];
        
        graphDisplayArea = (LinearLayout) view.findViewById(R.id.graphActivity);
        graphSleep = (LinearLayout) view.findViewById(R.id.graphSleep);
        graphBp = (LinearLayout) view.findViewById(R.id.graphBp);       
    
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
        
        
        graphView = new LineGraphView(getActivity(), " ");
        
        graphViewStep = new BarGraphView(getActivity(), "Steps");
        graphViewStep.addSeries(stepsSeries);
        graphViewStep.setHorizontalLabels(new String[] {"Apr 1"," ", " ", "Apr 7"});
        graphViewStep.getGraphViewStyle().setNumHorizontalLabels(0);
        graphViewStep.setManualYAxisBounds(2000, 0);
        
        graphViewSleep = new BarGraphView(getActivity(), "Sleep hours");
        graphViewSleep.addSeries(sleepSeries);
        graphViewSleep.setHorizontalLabels(new String[] {"Apr 1"," ", " ", "Apr 7"});
        graphViewSleep.getGraphViewStyle().setNumHorizontalLabels(0);
        graphViewSleep.setManualYAxisBounds(12, 0);
       
        graphViewBp = new LineGraphView(getActivity(), "Blood pressure");
        graphViewBp.addSeries(bpSystolicSeries);
        graphViewBp.addSeries(bpDiastolicSeries);
        graphViewBp.setHorizontalLabels(new String[] {"Apr 1"," ", " ", "Apr 7"});
        graphViewBp.getGraphViewStyle().setNumHorizontalLabels(0);
        graphViewBp.setManualYAxisBounds(150, 0);
        graphViewBp.setShowLegend(true);
        graphViewBp.setDrawDataPoints(true);
        graphViewBp.setLegendAlign(LegendAlign.TOP);
        graphViewBp.setLegendWidth(165);
        graphViewBp.setDataPointsRadius(4.0f);
        
        //graphViewBp.setDrawBackground(true);
        
        GraphView anotherGraphView = new BarGraphView(getActivity(), "");       
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
        
        
        graphDisplayArea.addView(graphViewStep);      
        graphSleep.addView(graphViewSleep);
        graphBp.addView(graphViewBp);

        return view;         
    }
     

}