package com.leetcode;

public class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0;
        int[] dp = new int[k+1];
        for(int i = cardPoints.length - 1; i >= cardPoints.length - k; --i){
            dp[0] += cardPoints[i];
        }
        res = dp[0];
        for(int i = 1; i < k+1; i++){
            dp[i] = dp[i-1] + cardPoints[i - 1] - cardPoints[cardPoints.length - 1 - k + i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        System.out.println(new MaximumPointsYouCanObtainfromCards().maxScore(arr, 3));
    }
}
