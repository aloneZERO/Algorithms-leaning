package com.leo.fundamentals;

import com.leo.api.Counter;
import com.leo.api.VisualAccumulator;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Date 2016-8-9
 * 
 * 数据抽象
 * @author leo
 *
 */
public class Capter2 {
	
	public static void main(String[] args) {
//		simulateRolls(10);
//		testVisualAccumulator(2000);
//		System.out.println(mystery("123456abcdef"));
//		minDistanceOfPoints(10);
		
		/*System.out.println(isLoopModification("CCABC", "CCEAB"));
		System.out.println(isLoopModification("CCABC", "CCCAB"));*/
		
	}
	
	/**
	 * 判断两个字符串是否互为回环变位
	 * 思路：
	 * 	如果字符串s和t互为回环变位，则s可分解为"AB"，t可分解为"BA"。
	 * 	那么t与自身拼接后则为"BABA"，显然是会包含s的。
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isLoopModification(String s, String t) {
		return (s.length()==t.length())&&((t+t).contains(s));
	}
	/**
	 * 判断两个字符串是否为回环变位
	 * 一般解法：
	 * 	遍历字符串 t，从不同的索引位置将字符串t分解成两个子串，交换顺序拼接后再与s相比是否相等。
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isCircularRotation(String s, String t) {
		if(s.length() != t.length()) return false;
		int length = s.length();
		for(int i = 1; i <= length; i++) {
			String left = s.substring(0, i);
			String right = s.substring(i, length);
			if ((right + left).equals(t)) {
				return true;
			}        
		}
		return false;
	}
	
	/**
	 * 单位正方形随机生成N个随机点：
	 * 计算两点之间的最近距离
	 * @param N
	 */
	public static void minDistanceOfPoints(int N) {
		Point2D[] points = new Point2D[N];
		// 单位正方形内随机生成N个随机点
		for(int i=0; i< N; i++) {
			double x = Math.random();
			double y = Math.random();
			points[i] = new Point2D(x, y);
		}
		double min = Math.sqrt(2); // 单位正方形内两点之间最大距离为2的平方根
		// 计算两点之间的最短距离
		for(int i=0; i< N; i++) {
			for(int j=i+1; j< N; j++) {
				System.out.println(points[i].distanceTo(points[j]));
				if(min >= points[i].distanceTo(points[j])) {
					min = points[i].distanceTo(points[j]);
				}
			}		
		}
		System.out.println("The minimum distance between two points: "+min);
	}
	
	/**
	 * 递归测试： 翻转字符串
	 * @param s
	 * @return
	 */
	public static String mystery(String s) {
		int N = s.length();
		if(N <= 1) return s;
		String a = s.substring(0,N/2);
		String b = s.substring(N/2,N);
		return mystery(b) + mystery(a);
	}
	
	/**
	 * 测试可视化累加器
	 * @param T
	 */
	public static void testVisualAccumulator(int T) {
		VisualAccumulator va = new VisualAccumulator(T,T);
		for(int i=0; i< T; i++) {
//			va.addDataValue(StdRandom.random());
			va.addDataValue(Math.random()*T);
		}
		System.out.println(va);
	}
	
	/**
	 * 模拟 rollTotal 次投掷骰子
	 * @param rollTotal
	 */
	public static void simulateRolls(int rollTotal) {
		final int SIDES	 = 6;
		Counter[] rolls = new Counter[SIDES+1];
		for(int i=1; i<= SIDES; i++) {
			rolls[i] = new Counter("Side."+i);
		}
		for(int t=0; t< rollTotal; t++) {
			int result = StdRandom.uniform(1, SIDES+1);
//			int result = (int)(Math.random()*6+1);
			rolls[result].increment();
		}
		for(int i=1; i<= SIDES; i++) {
			System.out.println(rolls[i]);
		}
	}
}
