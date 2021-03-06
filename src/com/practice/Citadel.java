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
	private static final int[] test = { 5, 10, 2, 4, 5, 6 };

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
				/*
				it means that we have found a point i where the price[i] is lower than the time we bought, and that we
				should then try to buy at point i to see if we can achieve a bigger gain
				 */
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
/*
A more clear explanation on why sum of subarray works.:

Suppose we have original array:
[a0, a1, a2, a3, a4, a5, a6]

what we are given here(or we calculate ourselves) is:
[b0, b1, b2, b3, b4, b5, b6]

where,
b[i] = 0, when i == 0
b[i] = a[i] - a[i - 1], when i != 0

suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
then in our given array, we need to find the sum of sub array from b3 to b6.

b3 = a3 - a2
b4 = a4 - a3
b5 = a5 - a4
b6 = a6 - a5

adding all these, all the middle terms will cancel out except two
i.e.

b3 + b4 + b5 + b6 = a6 - a2

a6 - a2 is the required solution.

so we need to find the largest sub array sum to get the most profit
 */