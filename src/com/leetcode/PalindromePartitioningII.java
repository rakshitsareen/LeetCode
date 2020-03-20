package com.leetcode;

public class PalindromePartitioningII {

	public int minCut(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		boolean[][] pali = new boolean[n][n];
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = i;
			for (int j = 0; j <= i; ++j) {
				if (c[i] == c[j] && (i - j < 2 || pali[j + 1][i - 1])) {
					pali[j][i] = true;
					dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
				}
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(new PalindromePartitioningII().minCut(s));

	}

}
