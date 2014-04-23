package com.mss.livesmart;

import com.jjoe64.graphview.BarGraphView;
import com.jjoe64.graphview.CustomLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.LegendAlign;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.GraphViewSeries.GraphViewSeriesStyle;
import com.jjoe64.graphview.LineGraphView;
import com.mss.livesmart.entities.HealthData;
import com.mss.livesmart.sampledata.SampleHealthData;
import com.mss.livesmart.sampledata.SampleJson;
import com.mss.livesmart.utils.JsonConvertor;
import com.mss.livesmart.utils.RecomHandler;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class HealthHistoryActivityDemoPerson3 extends Fragment {

	private LinearLayout graphDisplayArea, graphSleep, graphBp;
	Button b_get_recommendation;
	LineGraphView graphViewBp;
	BarGraphView graphViewSleep, graphViewStep;
	GraphViewSeries stepsSeries, sleepSeries, heartRateSeries,
			bpSystolicSeries, bpDiastolicSeries;
	private GraphViewData[] stepsData, sleepData, bpDiastolicData,
			bpSystolicData;
	final int weekly = 7;
	final int biweekly = 7;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.activity_health_history_person_3,
				container, false);
		stepsData = new GraphViewData[weekly];

		graphDisplayArea = (LinearLayout) view
				.findViewById(R.id.graphActivity3);
		graphSleep = (LinearLayout) view.findViewById(R.id.graphSleep3);
		graphBp = (LinearLayout) view.findViewById(R.id.graphBp3);
		b_get_recommendation = (Button) view.findViewById(R.id.btnRecommend3);

		// init example steps data
		stepsSeries = new GraphViewSeries("Steps", null, stepsData);
		GraphViewSeriesStyle sleepStyle = new GraphViewSeriesStyle(Color.GREEN,
				2);
		// init example sleeps data
		sleepData = new GraphViewData[weekly];
		for (int i = 0; i < weekly; i++) {
			sleepData[i] = new GraphViewData(i, SampleHealthData
					.getHealthData3().getSleep().get(i + biweekly)
					.getMinutesAsleep() / 60);
			stepsData[i] = new GraphViewData(i, SampleHealthData
					.getHealthData3().getActivities().get(i + biweekly)
					.getDuration());
		}

		sleepSeries = new GraphViewSeries("Sleep minutes", sleepStyle,
				sleepData);
		bpSystolicData = new GraphViewData[biweekly];
		bpDiastolicData = new GraphViewData[biweekly];
		for (int i = 0; i < biweekly; i++) {
			bpSystolicData[i] = new GraphViewData(i, SampleHealthData
					.getHealthData3().getBloodPressures().get(i + biweekly * 2)
					.getSystolic());
			bpDiastolicData[i] = new GraphViewData(i, SampleHealthData
					.getHealthData3().getBloodPressures().get(i + biweekly * 2)
					.getDiastolic());

		}
		GraphViewSeriesStyle bpStyle1 = new GraphViewSeriesStyle(Color.RED, 2);
		bpSystolicSeries = new GraphViewSeries("Systolic", bpStyle1,
				bpSystolicData);

		GraphViewSeriesStyle bpStyle2 = new GraphViewSeriesStyle(Color.YELLOW,
				2);
		bpDiastolicSeries = new GraphViewSeries("Diastolic", bpStyle2,
				bpDiastolicData);

		graphViewStep = new BarGraphView(getActivity(), "Steps");
		graphViewStep.addSeries(stepsSeries);
		graphViewStep.setHorizontalLabels(new String[] { "Apr 15", " ", " ",
				"Apr 21" });
		graphViewStep.getGraphViewStyle().setNumHorizontalLabels(0);
		graphViewStep.setManualYAxisBounds(200, 0);

		graphViewSleep = new BarGraphView(getActivity(), "Sleep hours");
		graphViewSleep.addSeries(sleepSeries);
		graphViewSleep.setHorizontalLabels(new String[] { "Apr 15", " ", " ",
				"Apr 21" });
		graphViewSleep.getGraphViewStyle().setNumHorizontalLabels(0);
		graphViewSleep.setManualYAxisBounds(12, 0);

		graphViewBp = new LineGraphView(getActivity(), "Blood pressure");
		graphViewBp.addSeries(bpSystolicSeries);
		graphViewBp.addSeries(bpDiastolicSeries);
		graphViewBp.setHorizontalLabels(new String[] { "Apr 15", " ", " ",
				"Apr 21" });
		graphViewBp.getGraphViewStyle().setNumHorizontalLabels(0);
		graphViewBp.setManualYAxisBounds(200, 0);
		graphViewBp.setShowLegend(true);
		graphViewBp.setDrawDataPoints(true);
		graphViewBp.setLegendAlign(LegendAlign.TOP);
		graphViewBp.setLegendWidth(165);
		graphViewBp.setDataPointsRadius(4.0f);

		graphDisplayArea.addView(graphViewStep);
		graphSleep.addView(graphViewSleep);
		graphBp.addView(graphViewBp);
		b_get_recommendation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				HealthData hd = JsonConvertor
						.SampleJsonToHealthDataObj(SampleJson.getRec3());
				RecomHandler
						.getRecommendation((HealthHistoryActivityDemoPerson3.this
								.getActivity()), hd);
			}

		});
		return view;
	}

}
