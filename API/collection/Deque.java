package com.leo.api.collection;

import java.util.Iterator;

/**
 * 基于双向链表实现的双端队列
 * @author leo
 *
 */
public class Deque<Item> implements Iterable<Item> {
	private DoubleLinkedList<Item> list;
	
	/**
	 * 初始化双端队列
	 */
	public Deque() {
		list = new DoubleLinkedList<>();
	}
	
	/**
	 * 从右端删除一个元素
	 * @return 删除的元素
	 */
	public Item popRight() {
		return list.removeLast();
	}
	
	/**
	 * 从左端删除一个元素
	 * @return 删除的元素
	 */
	public Item popLeft() {
		return list.removeFirst();
	}
	
	/**
	 * 向右端添加一个新元素
	 * @param item
	 */
	public void pushRight(Item item) {
		list.addLast(item);
	}
	
	/**
	 * 向左端添加一个新元素
	 * @param item
	 */
	public void pushLeft(Item item) {
		list.addFirst(item);
	}
	
	/**
	 * 返回双端队列中元素的数量
	 * @return 双端队列中元素的数量
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * 双端队列是否为空
	 * @return 空返回 true；否则返回 false
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * 返回双端队列的字符串形式
	 */
	@Override
	public String toString() {
		return list.toString();
	}

	/**
	 * 返回该双端队列的迭代器
	 */
	@Override
	public Iterator<Item> iterator() {
		return list.iterator();
	}
}
