package com.leetcode;

import java.util.Stack;

public class IntegerZip {

	public static int integerZip(int a, int b) {
		Stack<Integer> one = new Stack<Integer>();
		Stack<Integer> two = new Stack<Integer>();
		int temp = 0;
		while (a > 0) {
			temp = a % 10;
			a = a / 10;
			one.push(temp);
		}
		while (b > 0) {
			temp = b % 10;
			b = b / 10;
			two.push(temp);
		}
		StringBuilder s = new StringBuilder();
		while (!one.isEmpty() && !two.isEmpty()) {
			s.append(one.pop().toString()).append(two.pop().toString());
		}
		if (!one.isEmpty()) {
			while (!one.isEmpty()) {
				s.append(one.pop().toString());
			}
		}
		if (!two.isEmpty()) {
			while (!two.isEmpty()) {
				s.append(two.pop().toString());
			}
		}
		Integer res = Integer.parseInt(s.toString());
		if (res > 100000000)
			return -1;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(IntegerZip.integerZip(12345, 0));
	}

}
