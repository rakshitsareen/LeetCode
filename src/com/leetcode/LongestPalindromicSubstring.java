package com.leetcode;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int l = 0;
		int r = 0;
		if(s.length() == 0 || s.length() == 1) return s;
		for (int i = 0; i < n; ++i) {
			dp[i][i] = true;
			l = i;
			r = i;
		}
		for (int i = 0; i < n; ++i) {
			if (i + 1 < n) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					dp[i][i + 1] = true;
					l = i;
					r = i + 1;
				}
			}
		}
		for (int d = 1; d < n; ++d) {
			for (int i = 0; i + d < n; ++i) {
				int left = i + 1;
				int right = i + d - 1;
				if (left > right)
					continue;
				if (dp[left][right] == true && s.charAt(i) == s.charAt(i + d)) {
					dp[i][i + d] = true;
					if (r - l < d) {
						l = i;
						r = i + d;
					}
				}
			}
		}
		return s.substring(l, r + 1);
	}

	public static void outputdp(boolean[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
//		String s = "xyyxabcdcba";
//		String s = "xyyx";
		String s = "ccc";
		System.out.println(longestPalindrome(s));
	}

	/*
	 * public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;
	
    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}
	 */
}
