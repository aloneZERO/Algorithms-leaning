package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;

/**
 * 以栈为目标的队列
 * @author leo
 *
 */
public class Steque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		Item item;
		Node next;
		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
	}
	
	/**
	 * 初始化
	 */
	public Steque() {
		this.first = null;
		this.last = null;
		this.N = 0;
	}
	
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		Steque<String> ste = new Steque<>();
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if(item.equals("end")) break;
			else ste.enqueue(item);
		}
		System.out.println(ste);
	}
	
	/**
	 * 栈顶元素弹栈
	 * @return 栈顶元素
	 */
	public Item pop() {
		if(this.isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if(this.isEmpty()) last = null; // 避免对象游离
		return item;
	}
	
	/**
	 * 元素压栈
	 * @param item
	 */
	public void push(Item item) {
		if(this.isEmpty()) {
			first = new Node(item);
			last = first;
		} else {
			Node oldfirst = first;
			first = new Node(item);
			first.next = oldfirst;
		}
		N++;
	}
	
	/**
	 * 元素入队
	 */
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node(item);
		if(this.isEmpty()) first = last;
		else               oldlast.next = last;
		N++;
	}
	
	/**
	 * 返回元素数量
	 * @return 元素数量
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 判空
	 * @return 空，返回 true；否则，返回 false
	 */
	public boolean isEmpty() {
		return first==null&&N==0;
	}
	
	/**
	 * 返回该栈队列的字符串形式
	 */
	@Override
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
	
	/**
	 * 返回一个迭代器
	 * @return
	 */
	@Override
	public Iterator<Item> iterator() {
		return new SeqIterator();
	}
	private class SeqIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		@Override
		public void remove() { throw new UnsupportedOperationException(); }
	}

}
