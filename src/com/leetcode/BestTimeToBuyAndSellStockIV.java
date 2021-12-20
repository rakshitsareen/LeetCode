package com.leetcode;


public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(k >= len / 2) return quickSolve(prices);
        int[][] dp = new int[k + 1][len];
        for(int i = 1; i <= k; ++i){
            int tmpMax = -prices[0];
            for(int j = 1; j < len; ++j){
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    private int quickSolve(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
