package com.leetcode;

public class MinCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {
		if (null == cost || cost.length == 0)
			return 0;
		int[] dp = new int[cost.length + 1];
		for (int i = 0; i < cost.length; i++)
			dp[i] = cost[i];
		dp[dp.length - 1] = 0;
		for (int i = 2; i < dp.length; i++) {
			dp[i] += Math.min(dp[i - 1], dp[i - 2]);
		}
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		int[] cost = { 10, 15, 20 };
		int[] cost2 = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs(cost2));
	}
}
