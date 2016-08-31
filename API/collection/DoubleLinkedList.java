package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 双向链表
 * @author leo
 *
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {
	private Node first; // 头结点
	private Node last; // 尾结点
	private int N; // 链表元素数量（也即链表长度）
	
	private class Node {
		Node pre; // 前结点
		Node next; // 后结点
		Item item; // 数据域
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<String> dlist = new DoubleLinkedList<>();
		dlist.addLast("3");
		dlist.addLast("4");
		dlist.addFirst("1");
		dlist.addFirst("2");
		
		System.out.println(dlist);
		while(!dlist.isEmpty()) {
//			System.out.print(dlist.removeFirst()+" ");
			System.out.print(dlist.removeLast()+" ");
		}
		System.out.println();
	}
	
	/**
	 * 初始化双向链表
	 */
	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
		this.N = 0;
	}
	
	/**
	 * 移除表尾结点并返回其数据域
	 * @return 表尾结点的数据域
	 */
	public Item removeLast() {
		if(this.isEmpty()) throw new NoSuchElementException("DoubleLinkedList underflow");
		Item item = last.item;
		if(last.pre!=null) last.pre.next = null;
		last = last.pre;
		N--;
		if(this.isEmpty()) first = null; // 避免对象游离
		return item;
	}
	
	/**
	 * 移除表头结点并返回其数据域
	 * @return 表头结点的数据域
	 */
	public Item removeFirst() {
		if(this.isEmpty()) throw new NoSuchElementException("DoubleLinkedList underflow");
		Item item = first.item;
		if(first.next!=null) first.next.pre = null;
		first = first.next;
		N--;
		if(this.isEmpty()) last = null; // 避免对象游离
		return item;
	}
	
	/**
	 * 在表尾添加结点
	 * @param item
	 */
	public void addLast(Item item) {
		if(this.isEmpty()) {
			last = new Node();
			last.item = item;
			last.next = null;
			last.pre = null;
			first = last;
		}else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			last.pre = oldlast;
			oldlast.next = last;
		}
		N++;
	}
	
	/**
	 * 在表头添加结点
	 * @param item
	 */
	public void addFirst(Item item) {
		if(this.isEmpty()) {
			first = new Node();
			first.item = item;
			first.next = null;
			first.pre = null;
			last = first;
		} else {
			Node oldfirst = first;
			first = new Node();
			first.item = item;
			first.next = oldfirst;
			first.pre = null;
			oldfirst.pre = first;
		}
		N++;
	}
	
	/**
	 * 添加结点
	 * @param item
	 */
	public void add(Item item) {
		if(this.isEmpty()) {
			first = new Node();
			first.item = item;
			first.next = null;
			first.pre = null;
			last = first;
		}else {
			Node oldlast = last;
			last = new Node();
			last.item = item;
			last.next = null;
			last.pre = oldlast;
			oldlast.next = last;
		}
		N++;
	}
	
	/**
	 * 返回元素个数
	 * @return 元素个数
	 */
	public int size() {
		return this.N;
	}
	
	/**
	 * 判空
	 * @return 空返回 true；否则返回 false
	 */
	public boolean isEmpty() {
		return (first==null||last==null)&&N==0;
	}
	
	/**
	 * 返回该双向链表的字符串形式
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
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
		@Override
		public void remove() { throw new UnsupportedOperationException(); }
	}
	
}
