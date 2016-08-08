package com.leo.basic;

/**
 * 斐波拉契数列
 * @author leo
 *
 */
public class Fibonacci {
	public static void main(String[] args) {
		//Way.01
		/*for(int i=0; i< 100; i++) {
			System.out.println(i+" "+F(i));
		}*/
		
		/**
		 * Way.02
		 * 此时循环效率更高
		 */
		long f = 0;
		long temp = 1;
		for(int i=0; i< 100; i++) {
			System.out.println(i+" "+f);
			f = f + temp;
			temp = f - temp;
		}
	}
	
	/**
	 * 随着递归层数的加深，
	 * 结果返回的越来越慢
	 * @param N
	 * @return
	 */
	public static long F(int N) {
		if(N==0) return 0;
		if(N==1) return 1;
		return F(N-1)+F(N-2);
	}
}
