package com.leetcode;

public class PaintHouse {

	public static int minCost(int[][] costs) {
		if (null == costs || costs.length == 0)
			return 0;
		int N = costs.length;
		int[][] dp = new int[costs.length][costs[0].length];
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];
		for (int i = 1; i < N; i++) {
			// starting from box one.
			dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
			dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			dp[i][2] += Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
		}
		return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
	}

	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 9 } };
		System.out.println(minCost(costs));
	}

	public int minCostRevision(int[][] cost) {
		return 0;

	}

}
