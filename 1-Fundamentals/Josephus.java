package com.leo.fundamentals;

import edu.princeton.cs.algs4.StdIn;

/**
 * 2016/6/30 18:06:36
 * 单向循环链表，解约瑟夫环
 * 据说著名犹太历史学家 Josephus有过以下的故事：
 * 在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，
 * 39个犹太人决定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，
 * 由第1个人开始报数，每报数到第3人该人就必须自杀，然后再由下一个重新报数，
 * 直到所有人都自杀身亡为止。
 */
public class Josephus  {
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String args[]) {
        int n = StdIn.readInt();
        int k = StdIn.readInt();
        Josephus Jcycle = new Josephus(n);
        // Jcycle.output(n);
        Jcycle.go(n,k);
    }
	
	private Node head = null;
	
	public class Node  {
	    public int data;
	    public Node next;
	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	    public Node() {
	        this(0);
	    }
	}
	
	// 建立n个结点的单向循环链表
    Josephus(int n) {
		head = new Node();
		Node p = head;
        if(n > 0) {
            for(int i=1; i <= n; i++) {
			   p.next = new Node(i);
			   p = p.next;
            }
			p.next = head.next;
			head = p.next;
        }
    }
	public void go(int n, int k) {
		n %= k;
		Node p = head;
		while(p != p.next) {
			for(int i=0; i< n-1; i++)
				p = p.next;
			System.out.printf("No.%02d out !\n",p.next.data);
			deleteRear(p);
			p = p.next;
		}
		System.out.printf("No.%02d out !",p.data);
	}
	public void deleteRear(Node nd) { // 删除后继结点
		nd.next = nd.next.next;
	}
    public void output(int n) {
        Node p = head;
        for(int i=0; i< n; i++) {
			System.out.print(p.data+"->");
			p = p.next;
		}
		System.out.println(p.data);
    }
}
