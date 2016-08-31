package com.leo.api;

/**
 * 二分查找类为常用基本数据类型的数组提供了二分查找方法。
 * <p>
 * 包括：int[], long[], double[], float[]
 * 
 * @author leo
 *
 */
public class BinarySearch {
	
	/*
	 * 该类不需要实例化
	 */
	private BinarySearch(){}
	
	/**
	 * 返回 key 在数组中的下标。
	 * 不存在这样的 key，则返回 -1。
	 * 并保证返回匹配 key 的数组元素的最小索引。
	 * 
	 * @param a
	 * @param key
	 * @return 存在 key: 匹配 key 的数组元素的最小索引; 否则: -1
	 */
	public static int rank(int[] a, int key) {
		int le = 0; // 数组下标左边界
		int ri = a.length-1; // 数组下标右边界
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
	public static int rank(long[] a, long key) {
		int le = 0; // 数组下标左边界
		int ri = a.length-1; // 数组下标右边界
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
	public static int rank(double[] a, double key) {
		int le = 0; // 数组下标左边界
		int ri = a.length-1; // 数组下标右边界
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
	public static int rank(float[] a, float key) {
		int le = 0; // 数组下标左边界
		int ri = a.length-1; // 数组下标右边界
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
}
