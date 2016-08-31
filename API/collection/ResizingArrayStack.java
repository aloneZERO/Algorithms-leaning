package com.leo.api.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 下压栈(LIFO)
 * 
 * 泛型可迭代的Stack API是所有集合类抽象数据类型实现的模板。
 * 它将元素保存在数组中，并动态调整数组的大小以保持数组大小和栈大小之比小于一个常数。
 * 
 * @author leo
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
	@SuppressWarnings("unchecked")
	private Item[] items = (Item[]) new Object[1];
	private int N; // size
	
	/**
	 * 添加一个元素（元素压栈）
	 * @param item
	 */
	public void push(Item item) {
		if(N == items.length)
			resize(2*items.length);
		items[N++] = item;
	}
	
	/**
	 * 删除最近添加的元素（栈顶元素弹栈）
	 * @return
	 */
	public Item pop() {
		if(this.isEmpty()) throw new NoSuchElementException("ResizingArrayStack underflow");
		Item item =  items[--N];
		items[N] = null; // 避免对象游离
		if(N>0 && N==items.length/4) 
			resize(items.length/2);
		return item;
	}
	/**
	 * 返回栈顶元素，不删除元素
	 * @return
	 */
	public Item peek() {
		if(this.isEmpty()) throw new NoSuchElementException("ResizingArrayStack underflow");
		return items[N-1];
	}
	
	/**
	 * 调整数组大小
	 * 将大小为 N<= max 的栈移动到一个新的大小为max的数组中。
	 * @param max
	 */
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		Item[] temp = (Item[])new Object[max];
		for(int i=0; i< N; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}
	
	/**
	 * 栈是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return N==0;
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
