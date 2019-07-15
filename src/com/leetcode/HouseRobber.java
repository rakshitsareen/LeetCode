package com.leetcode;

public class HouseRobber {

	public static int rob(int[] nums) {
		if (null == nums || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] += Math.max(dp[i - 1], nums[i] + dp[i - 2]);
		}
		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int[] nums2 = { 2, 7, 9, 3, 1 };
		System.out.println(rob(nums2));
	}

}
