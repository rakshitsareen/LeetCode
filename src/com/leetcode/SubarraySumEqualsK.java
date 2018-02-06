package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
	// sum - k is complement.
	// we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i-1]
	// and SUM[0, j], then we can easily get SUM[i, j]. To achieve this, we
	// just need to go through the array, calculate the current sum and save number
	// of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).

	public static int subarraySum(int[] nums, int k) {
		int result = 0;
		Map<Integer, Integer> presum = new HashMap<>();
		presum.put(0, 1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (presum.containsKey(sum - k)) {
				result += presum.get(sum - k);
			}
			presum.put(sum, presum.getOrDefault(sum, 0) + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		System.out.println(subarraySum(nums, 2));
	}

}
