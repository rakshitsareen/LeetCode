package com.leetcode;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] new_nums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = new_nums[new_nums.length - 1] = 1;
        for(int k = 2; k < new_nums.length; ++k){
            for(int left = 0; left < new_nums.length - k; ++left){
                int right = left + k;
                for(int i = left + 1; i < right; ++i){
                    dp[left][right] = Math.max(dp[left][right],
                            new_nums[left] * new_nums[i] * new_nums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][new_nums.length - 1];
    }

    public static void main(String[] args){
        int[] arr = {3,1,5,8};
        BurstBalloons b = new BurstBalloons();
        System.out.println(b.maxCoins(arr));
    }

}
