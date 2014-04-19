package com.mss.livesmart;

import com.jjoe64.graphview.GraphViewDataInterface;

public class GraphViewData implements GraphViewDataInterface {

	public GraphViewData(double x, double y) {

		this.x = x;
		this.y = y;
	}

	private double x;
	private double y;

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
