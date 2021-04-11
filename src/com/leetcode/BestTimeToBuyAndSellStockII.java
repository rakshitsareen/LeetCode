package com.leetcode;


/*
 buy one and sell one share of the stock multiple times).
 non overlapping buy-sell
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1;i < prices.length; ++i){
            if(prices[i] > prices[i -1])
                profit += prices[i] - prices[i -1];
        }
        return profit;
    }
}
