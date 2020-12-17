package com.leetcode;

public class PalindromicSubstrings {

	public static int countSubstrings(String s) {
		int n = s.length();
		int num_pal = 0;
		boolean[][] dp = new boolean[n][n];
		for (int d = 0; d < n; ++d)
			for (int i = 0; i + d < n; ++i) {
				int j = i + d;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = i + 1 >= j - 1 || dp[i + 1][j - 1];
					if (dp[i][j])
						num_pal++;
				}
			}
		return num_pal;
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abbac"));
	}

}
