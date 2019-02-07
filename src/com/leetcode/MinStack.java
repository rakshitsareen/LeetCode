package com.leetcode;

import java.util.ArrayList;

public class MinStack {

	class Node {
		int val;
		int minTillNow;

		public Node(int val, int minTillNow) {
			this.val = val;
			this.minTillNow = minTillNow;
		}
	}

	private int top;
	private int globalMin;
	ArrayList<Node> stack;

	/** initialize your data structure here. */
	public MinStack() {
		this.top = -1;
		this.globalMin = Integer.MAX_VALUE;
		this.stack = new ArrayList<>();
	}

	public void push(int x) {
		if (x < this.globalMin)
			this.globalMin = x;
		this.stack.add(++top, new Node(x, this.globalMin));
	}

	public void pop() {
		if (this.top < 0)
			return;
		this.stack.remove(this.top--);
		if (top >= 0)
			this.globalMin = this.stack.get(this.top).minTillNow;
		else
			this.globalMin = Integer.MAX_VALUE;
	}

	public int top() {
		if (this.top < 0)
			return Integer.MIN_VALUE;
		return this.stack.get(top).val;
	}

	public int getMin() {
		if (this.top < 0)
			return Integer.MIN_VALUE;
		return this.globalMin;
	}

	public static void main(String[] args) {
		MinStack sol = new MinStack();
		sol.push(-2);
		sol.push(0);
		sol.push(-3);
		System.out.println(sol.getMin());
		sol.pop();
		System.out.println(sol.top());
		System.out.println(sol.getMin());
	}

}
