package com.leo.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Date 2016/7/20/10:57:42
 * @author leo
 *
 */
public class Capter1 {

	public static void main(String[] args) {
//		buildIn_constant();
//		bitOperator();
//		amazingExp();
//		isEqualOfThreeNum();
//		isBetweenZeroAndOne(0.00000001, 0.9999999999);
//		System.out.println(toBinaryString(10));
		
		/*boolean[][] bs = {
				{true,false,true},
				{false,true,false},
				{false,true,true}
		};printBooleanArray(bs);*/
		
		/*int[] a = {2,3,1,1,3,3,2};
		int[] his = histogram(a, 4);
		for(int i=0; i< his.length; i++) {
			System.out.println((i+1)+": "+his[i]);
		}*/
		
//		System.out.println(rec1(6));
		
		infoTable();
		
	}
	
	
	/**
	 * 读取信息打印信息表格
	 */
	public static void infoTable() {
		Scanner in = new Scanner(System.in);
		String line = null;
		List<InfoRow> infoList = new LinkedList<>();
		while(true) {
			line = in.nextLine();
			if(!line.equals("over")){
				String[] info = line.split(" ");
				infoList.add(new InfoRow(info[0], Integer.parseInt(info[1]),
						Integer.parseInt(info[2])));
			}else break;
		}
		for(InfoRow ir:infoList) {
			System.out.println(ir);
		}
		in.close();
	}
	
	
	/**
	 * 练习递归
	 * @param n
	 * @return
	 */
	public static String rec1(int n) {
		if(n<=0) return "*";
		return rec1(n-3)+n+rec1(n-2)+n;
	}
	
	/**
	 * 数组柱状图：
	 * 如果a[]中的值均在0~(M-1)之间，
	 * 返回数组中的所有元素之和应该和a.length相等
	 * @param a
	 * @param M
	 * @return
	 */
	public static int[] histogram(int[] a,int M) {
		int[] result = new int[M];
		for(int i=0; i< result.length; i++) {
			result[i] = countInArr(a,i+1);
		}
		return result;
	} //计算指定整数在数组中出现的次数
	public static int countInArr(int[] a,int n) {
		int count = 0;
		for(int i:a) {
			if(i==n) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 打印布尔数组
	 * @param bArr
	 */
	public static void printBooleanArray(boolean[][] bArr) {
		for(int i=0; i< bArr.length; i++) {
			for(int j=0; j< bArr[i].length; j++) {
				if(bArr[i][j]) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * 整数转换为以二进制表示的字符串
	 */
	public static String toBinaryString(int N) {
		String result = "";
		for(int i=N; i>0; i/=2) {
			result = (i%2) + result;
		}
		return result;
	}
	
	/**
	 * 判断x,y是否都严格位于0-1之间
	 * @param x
	 * @param y
	 */
	public static void isBetweenZeroAndOne(double x,double y) {
		boolean reslut = ((x>0.0&&x<1.0)?(y>0.0&&y<1.0):false);
		System.out.println(reslut);
	}
	
	/**
	 * 判断从键盘输入的三个整数是否相等
	 */
	public static void isEqualOfThreeNum() {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		if((a==b)?(a==c):false) {
			System.out.println("equal");
		}else {
			System.out.println("not equal");
		}
		in.close();
	}
	
	/**
	 * 神奇的表达式
	 */
	public static void amazingExp() {
		System.out.println("(0+15)/2="+((0+15)/2));
		System.out.println("2.0e-6*100000000.1="+(2.0e-6*100000000.1));
		System.out.println("(1+2.236)/2="+((1+2.236)/2));
		System.out.println("1+2+3+4.0="+(1+2+3+4.0));
		System.out.println("4.1>=4: "+(4.1>=4));
		System.out.println("1+2+\"3\"="+(1+2+"3"));
		System.out.println("'b'+'c'="+('b'+'c'));
		System.out.println("'a'+'a'="+('a'+'a'));
		System.out.println("(char)('a'+4)="+((char)('a'+4)));
	}
	
	/**
	 * Double内置常数：
	 * 正负无穷
	 */
	public static void buildIn_constant() {
		double inf = Double.POSITIVE_INFINITY;
		double inf2 = Double.NEGATIVE_INFINITY;
		System.out.println(inf+"\n"+inf2);
	}
	
	/**
	 * 位运算符测试
	 */
	public static void bitOperator() {
		System.out.println("1&0="+(1&0));
		System.out.println("1|0="+(1|0));
		System.out.println("1^0="+(1^0));
		System.out.println("0^0="+(0^0));
		System.out.println("1^1="+(1^1));
	}

}

/**
 * 信息表格单行信息
 * @author leo
 *
 */
class InfoRow {
	String name;
	int num1;
	int num2;
	public InfoRow(String name, int num1, int num2) {
		this.name = name;
		this.num1 = num1;
		this.num2 = num2;
	}
	@Override
	public String toString() {
		return name+" "+num1+" "+num2+" "+((double)num1/num2);
	}
}
