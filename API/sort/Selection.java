package com.leo.api.sort;

import edu.princeton.cs.algs4.StdIn;

/**
 * 选择排序
 * 
 * 特点：
 * 1. 运行时间和输入无关（即使对待有序数组，运行时间仍然一样）。
 * 2. 数据移动最少。
 * 3. 不善于利用输入的初始状态。
 * 
 * 适用于任意实现了 Comparable 接口的数据类型。
 * @author leo
 *
 */
public class Selection {
	
	private Selection() {}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i=0; i< N; i++) {
			int min = i;
			for(int j=i+1; j< N; j++)
				if(less(a[j], a[min])) min = j;
			exch(a, i, min);
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
	 * a o r t e x s m p l e 
	 * a e r t o x s m p l e 
	 * a e e t o x s m p l r 
	 * a e e l o x s m p t r 
	 * a e e l m x s o p t r 
	 * a e e l m o s x p t r 
	 * a e e l m o p x s t r 
	 * a e e l m o p r s t x 
	 * a e e l m o p r s t x 
	 * a e e l m o p r s t x 
	 * a e e l m o p r s t x 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = StdIn.readLine();
		String[] a = str.split(" ");
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
