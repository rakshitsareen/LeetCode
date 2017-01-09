package com.leetcode;

public class MinSizeSubArray {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		int j = 0;
		int size = Integer.MAX_VALUE;
		int sum = 0;
		boolean exists = false;
		while (j <= nums.length) {
			if (sum >= s) {
				exists = true;
				size = Math.min(size, j - i);
				sum -= nums[i++];
			} else {
				if (j == nums.length)
					break;
				sum += nums[j++];
			}
		}
		if (exists)
			return size;
		else
			return 0;
	}

	public static void main(String[] args) {

	}
}
