package com.leo.api;

/**
 * 计数器
 * 
 * 用于场景模拟，或者算法分析
 * @author leo
 *
 */
public class Counter {
	private final String name;
	private int count;
	
	/**
	 * 创建一个名为id的计数器
	 * @param id
	 */
	public Counter(String id) {
		this.name = id;
		this.count = 0; //default value is also zero
	}
	
	/**
	 * 将计数器的值加1
	 */
	public void increment() {
		this.count++;
	}
	
	/**
	 * 该对象创建之后计数器被加1的次数
	 * @return
	 */
	public int tally() {
		return this.count;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name+" "+this.count;
	}
	
}
