package com.leetcode;


public class MinimumDifficultyOfAJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        final int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        for(int i = 1; i < n; ++i){
            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i-1]);
        }

        for(int days = 1; days < d; ++days){
            for(int len = days; len < n; ++len){
                int localMax = jobDifficulty[len];
                dp[days][len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule >= days; --schedule){
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[days][len] = Math.min(dp[days][len], dp[days - 1][schedule - 1] + localMax);
                }
            }
        }
        return dp[d- 1][n -1];
    }
}
