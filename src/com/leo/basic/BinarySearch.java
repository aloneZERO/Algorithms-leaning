package com.leo.basic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args)throws Exception {
		int[] arr = new int[1000000];
		String data = readFileName();
		readInts(arr,data);
		Arrays.sort(arr);
		
		int key;
		while(true) {
			key = readInt();
			if(rank(key,arr)) System.out.println("Found It");
			else System.out.println("No Such Data");
		}
	}

	@SuppressWarnings("resource")
	public static void readInts(int[] arr,String data)throws Exception {
		InputStream raw_in = System.in;
		System.setIn(new FileInputStream(data));
		Scanner in=new Scanner(System.in);  
		for(int i=0; in.hasNextLine(); i++)
			arr[i] = Integer.parseInt(in.nextLine());
		System.setIn(raw_in);
	}
	public static boolean rank(int key, int[] a) {
		int up = 0;
		int down= a.length - 1;
		while(up <= down) {
			int mid = up + (down - up)/2;
			if(key < a[mid]) down = mid - 1;
			else if(key > a[mid]) up = mid + 1;
			else return true;
		}
		return false;
	}
	@SuppressWarnings("resource")
	public static String readFileName() {
		return new Scanner(System.in).nextLine();
	}
	@SuppressWarnings("resource")
	public static int readInt() {
		return new Scanner(System.in).nextInt();
	}
}