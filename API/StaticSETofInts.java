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
			else {
				while(mid>0 && a[--mid]==key); // 排除 mid 左边出现重复 key
				return mid+1;
			}
		}
		return -1;
	}
	
	/**
	 * 判断 key 是否在整数集合中
	 * @param key
	 * @return
	 */
	public boolean contains(int key) {
		return this.rank(key)!= -1;
	}
	
	/**
	 * 找出给定键的出现次数
	 * @param key
	 * @return 给定键的出现次数
	 */
	public int howMany(int key) {
	    int cnt = 0;
	    int k = rank(key);     // logN
	    int temp = k;
	    while(k>=0&&a[k--]==key)   // 左边重复的 key 个数包含当前
	    	cnt++;
	    while(temp>=0&&temp<a.length-1&&a[++temp]==key)  // 右边重复的 key 个数
	        cnt++;
	    return cnt;
	}
}
