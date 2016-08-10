package com.leo.fundamentals;

import java.util.Iterator;

import com.leo.api.collection.LinkedListQueue;
import com.leo.api.collection.LinkedListStack;
import com.leo.api.collection.ResizingArrayStack;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

/**
 * Date 2016-8-9
 * 
 * 背包，队列和栈
 * @author leo
 *
 */
public class Capter3 {
	public static void main(String[] args) {
//		stats();
//		System.out.println(Evaluate.eval());
//		testMyStack();
//		testMyLinkedListStack();
//		testMyLinkedListQueue();
		completeParenthese();
		
	}
	
	/**
	 * 给定输入，例如：
	 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
	 * 
	 * 打印补全左括号的结果：
	 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * 5 - 6 ) ) )
	 */
	public static void completeParenthese() {
		LinkedListStack<String> ops  = new LinkedListStack<>();
		LinkedListStack<String> vals = new LinkedListStack<>();
		while (!StdIn.isEmpty()) {
		    String s = StdIn.readString();
		    if(s.equals("("))      ;
		    else if(s.equals("+") || s.equals("-") ||
		            s.equals("*") || s.equals("/") ||
		            s.equals("sqrt")) ops.push(s);
		    else if(s.equals(")")) {
			    String op = ops.pop();
			    String v = vals.pop();
			    if (op.equals("+") || op.equals("-") ||
			    	op.equals("*") || op.equals("/"))
			        v = String.format("( %s %s %s )", vals.pop(), op, v);
			    else if(op.equals("sqrt"))
			        v = String.format("( %s %s )", op, v);
			        vals.push(v);
		    }else vals.push(s);
		} 
        System.out.println(vals.pop());
	}
	
	/**
	 * 测试手动实现的链表FIFO队列
	 * 
	 * 输入结束标记：end
	 * 
	 * 测试结果：
	 * first second third end
	 * iterator: first second third
	 * first second third (0 left on queue)
	 */
	public static void testMyLinkedListQueue() {
		LinkedListQueue<String> slq = new LinkedListQueue<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(item.equals("end")) break;
			else slq.enqueue(item);
		}
		Iterator<String> iterator = slq.iterator();
		System.out.print("iterator: ");
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
		while(!slq.isEmpty())
			System.out.print(slq.dequeue()+" ");
		System.out.println("("+slq.size()+" left on queue)");
	}
	
	/**
	 * 测试手动实现的链表下压栈
	 * 
	 * 输入结束标记：end
	 */
	public static void testMyLinkedListStack() {
		LinkedListStack<String> slist = new LinkedListStack<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(item.equals("end")) break;
			else slist.push(item);
		}
		Iterator<String> iterator = slist.iterator();
		System.out.print("iterator: ");
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
		while(!slist.isEmpty())
			System.out.print(slist.pop()+" ");
		System.out.println("("+slist.size()+" left on stack)");
	}
	
	/**
	 * 测试手动实现的下压栈
	 * 
	 * 输入结束标记：end
	 * 
	 * 测试结果：
	 * to be or not to be. it is a question. end
	 * iterator: question. a is it be. to not or be to
	 * question. a is it be. to not or be to (0 left on stack)
	 */
	public static void testMyStack() {
		ResizingArrayStack<String> ss = new ResizingArrayStack<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(item.equals("end")) break;
			else ss.push(item);
		}
		Iterator<String> iterator = ss.iterator();
		System.out.print("iterator: ");
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
		while(!ss.isEmpty())
			System.out.print(ss.pop()+" ");
		System.out.println("("+ss.size()+" left on stack)");
	}
	
	/**
	 * 队列：实现读取文件中存放的整型数据，
	 * 并返回数据存储的数组。
	 * @param fileName
	 */
	public static int[] readInts(String fileName) {
		In in = new In(fileName);
		Queue<Integer> queue = new Queue<>();
		while(!in.isEmpty()) {
			queue.enqueue(in.readInt());
		}
		
		int N = queue.size();
		int[] a = new int[N];
		for(int i=0; i< N; i++) {
			a[i] = queue.dequeue();
		}
		return a;
	}
	
	/**
	 * 背包典型用例：计算平均值和样本标准差
	 * 数的计算顺序和结果无关，因此bag类型解决此类问题显得尤为适合。
	 */
	public static void stats() {
		Bag<Double> numbers = new Bag<>();
		double d = StdIn.readDouble();
		while(d != -999) {
			numbers.add(d);
			d = StdIn.readDouble();
		}
		int N = numbers.size();
		
		double sum = 0.0;
		for(double x:numbers) 
			sum += x;
		double mean = sum/N;
		
		sum = 0.0;
		for(double x:numbers)
			sum += (x-mean)*(x-mean);
		double std = Math.sqrt(sum/(N-1));
		System.out.printf("Mean: %.2f\n",mean);
		System.out.printf("Std dev: %.2f", std);
	}
}
