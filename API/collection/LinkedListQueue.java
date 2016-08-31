package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 先进先出队列（链表实现）
 * @author leo
 *
 */
public class LinkedListQueue<Item> implements Iterable<Item> {
	private Node first; // 指向最早添加的结点的链接
	private Node last; // 指向最近添加的结点的连接
	private int N; // 队列元素数量
	
	/**
	 * 定义结点的嵌套类
	 * @author leo
	 */
	private class Node {
		Item item;
		Node next;
	}
	
	/**
	 * 初始化队列
	 */
	public LinkedListQueue() {
		this.first = null;
		this.last = null;
		this.N = 0;
	}
	
	/**
	 * 队列是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first==null&&N==0;
	}
	
	/**
	 * 队列中元素数量
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 添加元素入队列
	 * @param item
	 */
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(this.isEmpty()) first = last;
		else               oldlast.next = last;
		N++;
	}
	
	/**
	 * 删除元素出队列
	 * @return
	 */
	public Item dequeue() {
		if(this.isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if(this.isEmpty()) last = null; // 避免对象游离
		return item;
	}
	
	/**
	 * 返回该队列的字符串形式
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
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Item> {
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
