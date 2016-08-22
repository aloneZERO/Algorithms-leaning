package com.leo.api;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class ThreeSum {
	private final static int MAX = 1000000;
	
	private ThreeSum() {}
	
	/**
	 * 为 ThreeSum.count() 方法计时
	 */
	public static double timeTrial(int N) {
		int[] a = new int[N];
		for(int i=0; i< N; i++)
			a[i] = StdRandom.uniform(-MAX,MAX);
		Stopwatch timer = new Stopwatch();
		@SuppressWarnings("unused")
		int cnt = count(a);
		return timer.elapsedTime();
	}
	
	/**
	 * 为 ThreeSum.countFast() 方法计时
	 */
	public static double timeTrialFast(int N) {
		int[] a = new int[N];
		for(int i=0; i< N; i++)
			a[i] = StdRandom.uniform(-MAX,MAX);
		Stopwatch timer = new Stopwatch();
		@SuppressWarnings("unused")
		int cnt = countFast(a);
		return timer.elapsedTime();
	}
	
	/** 
	 * 统计和为 0 的三整数元组数量（优化版本）
	 * 
	 * 时间复杂度：O(N) = N^2lg(N)
	 */
	public static int countFast(int[] a) {
		Arrays.sort(a); // 归并排序 NlgN
		int N = a.length;
		int cnt = 0;
		for(int i=0; i< N; i++)
			for(int j=i+1; j< N; j++)
				if(BinarySearch.rank(a,-a[i]-a[j])> j) // 二分查找 lgN
					cnt++;
		return cnt;
	}
	
	/** 统计和为 0 的三整数元组数量（暴力算法）<br>
	 * <br>
	 * 分析运行时间模型: <br>
	 * 1000: 0.297 s <br>
	 * 2000: 2.153 s <br>
	 * 3000: 4.868 s <br>
	 * 4000: 11.451 s <br>
	 * 5000: 22.345 s <br>
	 * 6000: 38.521 s <br>
	 * 7000: 61.138 s <br>
	 * 8000: 91.103 s <br>
	 * <br>
	 * 时间复杂度：O(N) = N^3
	 */
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for(int i=0; i< N; i++)
			for(int j=i+1; j< N; j++)
				for(int k=j+1; k< N; k++)
					if((long)a[i]+a[j]+a[k]==0)
						cnt++;
		return cnt;
	}
}
