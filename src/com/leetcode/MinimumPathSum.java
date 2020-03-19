package com.leetcode;

import java.util.Arrays;

public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		if (grid == null)
			return 0;
		if (grid.length == 0)
			return 0;
		if (grid.length == 1) {
			int sum = 0;
			for (int j = 0; j < grid[0].length; j++) {
				sum += grid[0][j];
			}
			return sum;
		}
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int j = 1; j < grid[0].length; j++) {
			dp[0][j] = dp[0][j - 1] + grid[0][j];
		}

		for (int i = 1; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
					continue;
				}
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
			}
		return dp[grid.length - 1][grid[0].length - 1];
	}
	
    public int minPathSum_secondtry_revision(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        if(grid.length == 1)
            return Arrays.stream(grid[0]).sum();
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i-1] + grid[0][i];
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int i = 1; i < m; ++i)
            for(int j = 1; j < n; ++j){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		int[][] nums = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(nums));
	}

}
