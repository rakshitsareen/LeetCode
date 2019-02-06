package com.leetcode;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		if (s == null)
			return null;
		if (s.length() == 0 || s.length() == 1)
			return s;
		int n = s.length();
		int maxleft = -1;
		int maxright = -1;
		boolean[][] dp = new boolean[n][n];
		// for substrings of length 1
		for (int i = 0; i < n; i++) {
			// every substring starting at i and ending at i is a palindrome.
			dp[i][i] = true;
			maxleft = i;
			maxright = i;
		}

		// for substrings of length 2.
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				maxleft = i;
				maxright = i + 1;
			} else
				dp[i][i + 1] = false;
		}
		// for substrings equal to greater than length 3
		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				if (i < n && j < n)
					if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
						// found a new palindrome substring
						dp[i][j] = true;
						maxleft = i;
						maxright = j;
						// System.out.println(i + " " + j);
					}
			}
		}
		// System.out.println(maxleft);
		// System.out.println(maxright + 1);
		return s.substring(maxleft, maxright + 1);
	}

	public static void ouputdp(boolean[][] dp, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String s = "xyxabcdcba";
		System.out.println(longestPalindrome(s));
	}
}
