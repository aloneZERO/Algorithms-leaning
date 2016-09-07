package com.leo.api.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * 插入排序
 * 
 * 特点：
 * 1. 运行时间取决于输入元素的初始顺序。
 * 2. 对某种类型的非随机数组排序效果显著。
 * 
 * 适用于任意实现了 Comparable 接口的数据类型。
 * @author leo
 *
 */
public class Insertion {
	
	private Insertion() {}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i=1; i< N; i++) {
			for(int j=i; j>0 && less(a[j],a[j-1]);j--)
				exch(a, j, j-1);
			show(a);
		}
	}
	
	/**
	 * is v < w ?
	 * @param v
	 * @param w
	 * @return v<w-true; v>w-false
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a,int i, int j) {
		Comparable t = a[i];
		        a[i] = a[j];
		        a[j] = t;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static void show(Comparable[] a) {
		for(int i=0; i< a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] a) {
		for(int i=1; i< a.length; i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}
	
	/**
	 * 测试结果
	 * Input:
	 * s o r t e x a m p l e 
	 * 
	 * Sort process:
	 * o s r t e x a m p l e 
	 * o r s t e x a m p l e 
	 * o r s t e x a m p l e 
	 * e o r s t x a m p l e 
	 * e o r s t x a m p l e 
	 * a e o r s t x m p l e 
	 * a e m o r s t x p l e 
	 * a e m o p r s t x l e 
	 * a e l m o p r s t x e 
	 * a e e l m o p r s t x
	 * @param args
	 */
	public static void main(String[] args) {
		String str = StdIn.readLine();
		String[] a = str.split(" ");
		sort(a);
		assert isSorted(a);
	}
}
