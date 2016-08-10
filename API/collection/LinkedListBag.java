package com.leo.api.collection;

import java.util.Iterator;

/**
 * 背包（链表实现）
 * @author leo
 *
 */
public class LinkedListBag<Item> implements Iterable<Item> {
	private Node first; // 链表首结点
	private int N;
	private class Node {
		Item item;
		Node next;
	}
	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	
	/**
	 * 背包是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first==null&&N==0;
	}
	
	/**
	 * 栈背包中元素数量
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 返回一个迭代器
	 * @return
	 */
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	private class BagIterator implements Iterator<Item> {
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
