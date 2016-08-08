package com.leo.api;

/**
 * 累加器
 * 
 * 计算机一组数据的实时平均值
 * @author leo
 *
 */
public class Accumulator {
	private double total;
	private int N;
	
	/**
	 * 添加一个新的数据值
	 * @param val
	 */
	public void addDataValue(double val) {
		this.N++;
		this.total += val;
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
