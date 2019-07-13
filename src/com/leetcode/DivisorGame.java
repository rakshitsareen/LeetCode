package com.leetcode;

public class DivisorGame {

	public static boolean divisorGame(int N) {
		boolean[] dp = new boolean[N + 1];
		dp[0] = false;
		dp[1] = false;
		for (int i = 2; i <= N; i++) {
			for (int divisor = i / 2; divisor >= 1; divisor--) {
				if (i % divisor == 0 && dp[i - divisor] == false)
					dp[i] = true;
			}
		}
		return dp[N];
	}

	public static void main(String[] args) {
		System.out.println(divisorGame(6));
	}

}
