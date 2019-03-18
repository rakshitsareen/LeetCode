package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a 
 * continuous sub array of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n 
 * is also an integer.
 */

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums.length <= 1)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			if(k != 0) runningSum %= k;
			Integer prev = map.get(runningSum);
			if (null != prev) {
				if (i - prev > 1)
					return true;
			} else
				map.put(runningSum, i);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
