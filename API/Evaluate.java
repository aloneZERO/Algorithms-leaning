package com.leo.api;

import java.util.Scanner;
import java.util.Stack;

/**
 * Date 2016-8-9
 * 
 * 提供复杂运算
 * @author leo
 *
 */
public class Evaluate {
	/**
	 * 计算控制台输入的数学表达式的结果
	 * 原理：双栈实现逆波兰表达式计算。
	 * 
	 * 样例输入：( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) =
	 * 注意事项：字符之间用空格隔开，等号('=')是结束标记！
	 * @return
	 */
	public static double eval() {
		Stack<String> ops = new Stack<>(); // 运算符栈
		Stack<Double> vals = new Stack<>(); // 操作数栈
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			// 读取字符，如果是运算符则压栈
			String s = in.next();
			if(s.equals("=")) break;
			if(s.equals("("))         ; // do nothing
			else if(s.equals("+"))    ops.push(s);
			else if(s.equals("-"))    ops.push(s);
			else if(s.equals("*"))    ops.push(s);
			else if(s.equals("/"))    ops.push(s);
			else if(s.equals("sqrt")) ops.push(s);
			else if(s.equals(")")) {
				// 如果字符为')',弹出运算符和操作数，计算结果并压入栈
				String op = ops.pop();
				double v = vals.pop();
				if(op.equals("+"))         v += vals.pop();
				else if(op.equals("-"))    v = vals.pop() - v;
				else if(op.equals("*"))    v *= vals.pop();
				else if(op.equals("/"))    v = vals.pop() / v;
				else if(op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			} // 如果字符既非运算符也不是括号，将它作为double值压栈
			else vals.push(Double.parseDouble(s));
		}
		while(!ops.isEmpty()) {
			String op = ops.pop();
			double v = vals.pop();
			if(op.equals("+"))         v += vals.pop();
			else if(op.equals("-"))    v = vals.pop() - v;
			else if(op.equals("*"))    v *= vals.pop();
			else if(op.equals("/"))    v = vals.pop() / v;
			else if(op.equals("sqrt")) v = Math.sqrt(v);
			vals.push(v);
		}
		in.close();
		return vals.pop();
	}
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(eval());
	}
}
