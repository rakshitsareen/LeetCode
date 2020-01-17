package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence {

	public static int longestArithSeqLength(int[] A) {
		if (A.length <= 1)
			return 0;
		if (A.length == 2)
			return 2;
		int longestLengthEverSeen = 0;
		Map<Integer, Integer>[] dp = new HashMap[A.length];
		for (int i = 0; i < A.length; ++i)
			dp[i] = new HashMap<>();
		for (int i = 1; i < A.length; ++i) {
			for (int j = 0; j < i; ++j) {
				int diff = A[i] - A[j];
				if (dp[j].containsKey(diff)) {
					int len = dp[j].get(diff);
					int curr = dp[i].getOrDefault(diff, 0);
					dp[i].put(diff, Math.max(curr, len + 1));
				} else {
					int curr = dp[i].getOrDefault(diff, 0);
					dp[i].put(diff, Math.max(curr, 2));
				}
				longestLengthEverSeen = Math.max(longestLengthEverSeen, dp[i].get(diff));
			}
		}
		return longestLengthEverSeen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 20, 1, 15, 3, 10, 5, 8 };
		System.out.println(longestArithSeqLength(A));
	}

}
