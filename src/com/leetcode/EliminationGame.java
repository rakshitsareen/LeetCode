package com.leetcode;

public class EliminationGame {

	public static int lastRemaining(int n) {
		int head = 1;
		boolean left = true;
		int remaining = n;
		int step = 1;
		while (remaining > 1) {
			if (left || remaining % 2 == 1) {
				head += step;
			}
			left = !left;
			step = step * 2;
			remaining /= 2;
		}
		return head;
	}

	public static void main(String[] args) {
		System.out.println(lastRemaining(9));

	}

}
