package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 定容栈
 * @author leo
 *
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {
	private Item[] items;
	private int N; // size
	
	/**
	 * 创建一个容量为cap的空栈
	 * @param cap
	 */
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		items = (Item[]) new Object[cap];
	}
	
	/**
	 * 添加一个元素（元素压栈）
	 * @param item
	 */
	public void push(Item item) {
		items[N++] = item;
	}
	
	/**
	 * 删除最近添加的元素（栈顶元素弹栈）
	 * @return
	 */
	public Item pop() {
		if(this.isEmpty()) throw new NoSuchElementException("FixedCapacityStack underflow");
		Item item =  items[--N];
		items[N] = null; // 避免对象游离
		return item;
	}
	/**
	 * 返回栈顶元素，不删除
	 * @return
	 */
	public Item peek() {
		if(this.isEmpty()) throw new NoSuchElementException("FixedCapacityStack underflow");
		return items[N-1];
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N==0;
	}
	
	/**
	 * 栈容量是否已满
	 * @return
	 */
	public boolean isFull() {
		return N==items.length;
	}
	
	/**
	 * 栈中的元素数量
	 * @return
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 返回一个自己定制的迭代器
	 * @return
	 */
	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	/**
	 * 嵌套类实现逆序迭代器
	 * @author leo
	 *
	 */
	private class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			return items[--i];
		}
		@Override
		public void remove() { throw new UnsupportedOperationException(); }
	}
}

