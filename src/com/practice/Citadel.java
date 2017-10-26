package com.practice;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 [8, 10, 2, 4, 5, 6] -> 4
 [5, 10, 2, 4, 5, 6] -> 5
 [10, 6, 5, 4, 2]    -> 0
 I want the max profit, 4,
 1) I can only buy once and sell once
 2) Must buy before I can sell
 */

class Citadel {
	private static int[] test = { 5, 10, 2, 4, 5, 6 };

	synchronized private static int maxProfit(int[] test) {
		if (test == null || test.length == 0)
			return 0;
		int[] change = new int[test.length - 1];
		for (int i = 0; i < test.length - 1; i++) {
			change[i] = test[i + 1] - test[i];
		}
		int end = 0;
		int sumHere = 0, maxSum = Integer.MIN_VALUE;
		while (end < change.length) {
			sumHere += change[end++];
			if (sumHere < 0) {
				sumHere = 0;
			}
			if (sumHere > maxSum) {
				maxSum = sumHere;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(test));
	}
}