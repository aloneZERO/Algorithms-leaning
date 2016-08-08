package com.leo.api;

import java.util.Arrays;

public class StaticSETofInts {
	private int[] a; // 存储目标数据集
	
	/**
	 * 创建一个整型数值的静态集合
	 * @param keys
	 */
	public StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for(int i=0; i< keys.length; i++) {
			a[i] = keys[i]; //保护性复制
		}
		Arrays.sort(a);
	}
	
	/**
	 * 二分查找
	 * @param key
	 * @return
	 */
	private int rank(int key) {
		int le = 0;
		int ri = a.length-1;
		while(le <= ri) {
			int mid = le + (ri-le)/2;
			if(key< a[mid]) ri = mid - 1;
			else if(key> a[mid]) le = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	/**
	 * 判断key是否在整数集合中
	 * @param key
	 * @return
	 */
	public boolean contains(int key) {
		return this.rank(key)!= -1;
	}
}
