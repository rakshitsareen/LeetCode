package com.leetcode;

import java.util.Stack;

public class MaxStack {

	Stack<Integer> st;
	Stack<Integer> maxStack;

	/** initialize your data structure here. */
	public MaxStack() {
		st = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public void push(int x) {
		int tempmax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
		if (x > tempmax)
			tempmax = x;
		st.push(x);
		maxStack.push(tempmax);
	}

	public int pop() {
		if(st.isEmpty()) return 
		maxStack.pop();
		return st.pop();
	}

	public int top() {
		return st.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int max = maxStack.peek();
		Stack<Integer> temp = new Stack<Integer>();
		while (st.peek() != max) {
			temp.push(st.pop());
			maxStack.pop();
		}
		st.pop();
		maxStack.pop();
		while (!temp.isEmpty()) {
			int x = temp.pop();
			push(x);
		}
		return max;
	}

}
