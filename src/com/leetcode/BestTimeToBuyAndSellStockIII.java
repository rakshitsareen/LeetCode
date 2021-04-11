package com.leetcode;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        if(prices == null || prices.length == 0) return 0;
        int lmin = prices[0];
        int rmax = prices[prices.length - 1];
        int[] leffProfits = new int[prices.length], rightProfits = new int[prices.length + 1];
        for(int i = 1; i < prices.length; ++i){
            leffProfits[i] = Math.max(leffProfits[i-1], prices[i] - lmin);
            lmin = Math.min(lmin, prices[i]);
            int right = prices.length - 1 - i;
            rightProfits[right] = Math.max(rightProfits[right + 1], rmax - prices[right]);
            rmax = Math.max(rmax, prices[right]);
        }
        for(int i = 0; i < prices.length; ++i){
            profit = Math.max(profit, leffProfits[i] + rightProfits[i + 1]);
        }
        return profit;
    }
}
