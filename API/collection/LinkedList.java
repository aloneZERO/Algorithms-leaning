package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 链表
 * @author leo
 *
 */
public class LinkedList<Item> implements Iterable<Item> {
	private Node first; // 表头
	private int N; // 元素数量
	
	private class Node {
		Item item;
		Node next;
		public Node(Item item) {
			this.item = item;
			this.next = null;
		}
	}
	
	/**
	 * 初始化链表
	 */
	public LinkedList() {
		this.first = null;
		this.N = 0;
	}
	
	/**
	 * 插入元素
	 */
	public void insert(Item item) {
		Node newNode = new Node(item);
		if(isEmpty()) {
			first = new Node(item);
		}else {
			Node head = first;
			while(head.next!=null)
				head = head.next;
			head.next = newNode;
		}
		N++;
	}
	
	/**
	 * 删除链表尾元素并返回
	 * @return
	 */
	public Item deleteEnd() {
		if(this.isEmpty()) throw new NoSuchElementException();
		Node head = first;
		Node aim = null;
		while(head.next != null) {
			aim = head;
			head = head.next;
		}
		Item item = head.item;
		aim.next = null;
		N--;
		return item;
	}
	
	/**
	 * 删除链表的第k个元素
	 * @param k
	 */
	public void delete(int k) {
		if(k>0 && k<=N) {
			Node head = first;
			for(int i=1; i<k-1; i++)
				head = head.next;
			head.next = head.next.next;
		} else throw new NoSuchElementException();
	}
	
	/**
	 * 删除链表中所有item域为key的结点
	 * @param key
	 */
	public void removeAllKey(Item key) {
		Node nowNode = first;
		while(nowNode != null) {
			if(nowNode.item.equals(key)) {
                if(nowNode.next == null) break;
                
                // nowNode 代替下一个结点
                Node nextNode = null;
                nextNode = nowNode.next;
                nowNode.item = nextNode.item;
                nowNode.next = nextNode.next;
                nextNode = null;
            }else nowNode=nowNode.next;
		}
	}
	
	/**
	 * 打印链表
	 */
	public void print() {
		Node head = first;
		while(head != null) {
			System.out.print(head.item+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return first==null&&N==0;
	}
	
	/**
	 * 链表中元素数量
	 * @return
	 */
	public int size() {
		return N;
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
