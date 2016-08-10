package com.leo.api.collection;

import java.util.Iterator;

/**
 * 下压堆栈(链表实现)
 *  
 * 最优设计目标:
 *  1. 可以处理任意类型的数据。
 *  2. 所需空间总是和集合的大小成正比。
 *  3. 操作所需时间总是和集合大小无关 。
 * @author leo
 *
 */
public class LinkedListStack<Item> implements Iterable<Item> {
	private Node first; // 栈顶（最近添加的元素）
	private int N; // 元素数量
	
	/**
	 * 定义了结点的嵌套类
	 */
	public class Node {
		Item item;
		Node next;
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first==null&&N==0;
	}
	
	/**
	 * 栈中元素数量
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 元素压栈：
	 * 向栈顶添加元素
	 */
	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	/**
	 * 元素弹栈：
	 * 从栈顶删除元素
	 * @return
	 */
	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	/**
	 * 返回栈顶，不删除元素
	 * @return
	 */
	public Item peek() {
		return first.item;
	}
	
	/**
	 * 返回一个迭代器
	 * @return
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current!=null;
		}
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		@Override
		public void remove() {}
	}
}
