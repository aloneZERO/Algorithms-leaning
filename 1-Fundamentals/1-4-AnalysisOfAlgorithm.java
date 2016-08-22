package com.leo.fundamentals;

import java.util.Arrays;

import com.leo.api.BinarySearch;
import com.leo.api.StaticSETofInts;
import com.leo.api.ThreeSum;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 算法分析
 * 
 * @date 2016-8-19
 * @author leo
 *
 */
public class Capter4 {
	public static void main(String[] args) {
		/* Violent - Optimized
		 * 0.312   - 0.265
		 * 1.466   - 1.436
		 * 4.87    - 4.853
		 * 11.468  - 11.467
		 * 22.311  - 22.342
		 * 38.661  - 38.565
		 * 61.153  - 61.137
		 * 91.183  - 91.152
		 * 130.31  - 130.231
		 * 178.122 - 178.494
		 */
		/*for(int i=1000; i<=10000; i+=1000) {
			testStopwatch(i);
		}*/
//		threeSumRatio();
		
		int[] a = {1,1,2,4,4,4,4,5,6,6};
		int[] b = {3,3,4,4,5,6,6,6,7,8};
		@SuppressWarnings("unused")
		int index = BinarySearch.rank(a, 4);
//		System.out.println(index);
		
		StaticSETofInts intSet = new StaticSETofInts(a);
		int n = intSet.howMany(4);
//		System.out.println(n);
		
		printCommonElem(a, b, 10);
		
	}
	
	/**
	 * 有序打印给定的两个数组中的所有公共元素(数组元素个数均为 N)
	 * @param a
	 * @param b
	 */
	public static void printCommonElem(int[] a,int[] b,int N) {
		Arrays.sort(a);
		Arrays.sort(b);
		int last = Integer.MIN_VALUE; // 保存上次查询的元素，用于避免重复键的重复打印
		for(int i=0; i< N; i++) {
			if(BinarySearch.rank(a, b[i])>0&&b[i]!=last)
				System.out.print(b[i]+" ");
			last = b[i];
		}
	}
	
	/**
	 * ThreeSum 倍率实验<br>
	 * 倍率可以简单有效地预测程序的性能并判断它们的运行时间大致的增长数量级。<br>
	 * <br>
	 * N        Time  Ratio <br>
	 * 1100     0.4   1.2 <br>
	 * 1200     0.3   0.9 <br>
	 * 2000     1.5   1.2 <br>
	 * 3000     4.9   1.1 <br>
	 * 4000    11.5   1.1 <br>
	 * 5000    22.4   1.1 <br>
	 * 6000    38.5   1.1 <br>
	 * 7000    61.0   1.0 <br>
	 */
	public static void threeSumRatio() {
		double prev = ThreeSum.timeTrial(1000);
		for(int N=1100; true; N+=100) {
			double time = ThreeSum.timeTrial(N);
			System.out.printf("%6d %7.1f ",N,time);
			System.out.printf("%5.1f\n",time/prev);
			prev = time;
		}
	}
	
	/**
	 * 测试计时器
	 * 
	 * @param N
	 * @return
	 */
	public static void testStopwatch(int N) {
		int[] a = new int[N];
		for(int i=0; i< N; i++)
			a[i] = StdRandom.uniform(-1000000,1000000);
		
		int cnt = ThreeSum.count(a);
		double time = ThreeSum.timeTrial(N);
		System.out.println("Violent: "+cnt+" triples. "+time+" seconds");
		
		int cnt2 = ThreeSum.countFast(a);
		double time2 = ThreeSum.timeTrialFast(N);
		System.out.println("Optimized: "+cnt2+" triples. "+time2+" seconds");
	}
	
}
