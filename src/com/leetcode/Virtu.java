package com.leetcode;

import java.util.Arrays;

public class Virtu {

	public static int fib(int n, int[] dp) {
		if (n == 0) {
			dp[n] = 0;
			return n;
		}
		if (n == 1) {
			dp[n] = 1;
			return n;
		}

		else {
			if (dp[n] != 0)
				return dp[n];
			else {
				if (dp[n - 1] == 0) {
					dp[n - 1] = fib(n - 1, dp);
					dp[n - 2] = fib(n - 2, dp);
				}
			}
		}
		return dp[n - 1] + dp[n - 2];
	}

	public static int solution(int X) {
		int[] dp = new int[X + 2];
		fib(X, dp);
		int i = 0;
		int prev = i;
		int k = 0;
		while (i < X) {
			prev = i;
			i = dp[k++];
		}
		return Math.abs(prev - X) > Math.abs(i - X) ? Math.abs(i - X) : Math.abs(prev - X);
	}

	public static int apples(int[] A) {
		if (A == null)
			return 0;
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return 0;
		int rem = 5000 - A[0];
		int[] b = new int[A.length - 1];
		for (int i = 0; i < b.length; i++) {
			b[i] = A[i + 1];
		}
		Arrays.sort(b);
		int count = 0;
		int i = 0;
		while (rem >= 0 && i < b.length) {
			rem = rem - b[i];
			if (rem >= 0)
				count++;
			i++;
		}
		return count;
	}

	public static String hexspeak(String s) {
		Integer i = Integer.parseUnsignedInt(s);
		String hex = Integer.toHexString(i);
		StringBuilder sb = new StringBuilder(hex);
		for (int k = 0; k < sb.length(); k++) {
			if (sb.charAt(k) == '1') {
				sb.setCharAt(k, 'I');
			}
			if (sb.charAt(k) == '0') {
				sb.setCharAt(k, 'O');
			}
		}
		System.out.println(sb);
		for (int k = 0; k < sb.length(); k++) {
			if (sb.charAt(k) != 'A' && sb.charAt(k) != 'B' && sb.charAt(k) != 'C' && sb.charAt(k) != 'D'
					&& sb.charAt(k) != 'E' && sb.charAt(k) != 'F' && sb.charAt(k) != 'I' && sb.charAt(k) != 'O') {
				return "ERROR";
			}
		}
		return sb.toString().toUpperCase();
	}

	public static boolean containsSame(String s, int i, int j) {
		char c = s.charAt(i);
		for (int k = i; k <= j; k++) {
			if (s.charAt(k) != c)
				return false;
		}
		return true;
	}

	public static int count(String s) {
		if (s == null)
			return 0;
		if (s.length() == 1)
			return 1;
		if (s.length() == 0)
			return 0;
		int res = s.length();
		for (int window = 2; window < s.length(); window++) {
			for (int i = 0; i < s.length() - window; i++) {
				if (containsSame(s, i, i + window - 1)) {
					res++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// Virtu sol = new Virtu();
		// System.out.println(sol.solution(15));
		System.out.println(solution(1));

	}

}
