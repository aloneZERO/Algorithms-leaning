package com.leo.api;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 可视化累加器
 * 
 * @author leo
 *
 */
public class VisualAccumulator {
	private double total;
	private int N;
	
	/**
	 * 创建一个可视化累加器
	 * @param trials
	 * @param max
	 */
	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0,trials);
		StdDraw.setYscale(0,max);
		StdDraw.setPenRadius(0.005);
	}
	
	/**
	 * 添加一个新的数据值
	 * @param val
	 */
	public void addDataValue(double val) {
		this.N++;
		this.total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	
	/**
	 * 所有数据值的平均值
	 * @return
	 */
	public double mean() {
		return this.total/this.N;
	}
	
	@Override
	public String toString() {
		return "Mean ("+N+" values): "+String.format("%7.5f", mean());
	}
	
}
