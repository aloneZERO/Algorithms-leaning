package com.leo.api;

/**
 * 计时器
 * 
 * 单位：秒
 * @author leo
 *
 */
public class Stopwatch {
	private final long start;
	
	public Stopwatch() {
		this.start = System.currentTimeMillis();
	}
	
	/**
	 * 返回对象创建以来所经历的时间（单位：秒）
	 * @return
	 */
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now-start)/1000.0;
	}
}
