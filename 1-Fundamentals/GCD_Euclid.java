package com.leo.fundamentals;

import java.util.Scanner;

public class GCD_Euclid {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		System.out.println("("+p+","+q+")Greatest Common Divisor is "+gcd(p,q));
		in.close();
	}
	
	public static int gcd(int p, int q) {
		if(q==0) return p;
		int r = p%q;
		return gcd(q, r);
	}
	
}