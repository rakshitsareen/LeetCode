package com.leetcode;

public class CountingBits {

	public static int[] countBits(final int num) {
		int [] dp = new int[num+1];
		dp[0] = 0;
		for(int i = 1; i <= num; i++)
			dp[i] = dp[i >> 1] + (i&1);
		return dp;
	}

	public static void main(String[] args) {
		int[] output = countBits(64);
		for (int p : output)
			System.out.print(p + ",");
//		System.out.println(Integer.bitCount(63));
	}

}
