package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
	public int maxSubArrayLen(int[] nums, int k) {
		int[] prefix = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; ++i) {
			prefix[i] = i == 0 ? nums[0] : prefix[i - 1] + nums[i];
			if (!map.containsKey(prefix[i]))
				map.put(prefix[i], i);
		}

		int j = -1;
		int max = -1;
		for (int i = 0; i < prefix.length; ++i) {
			j = map.getOrDefault(prefix[i] - k, -2);
			if (j < -1)
				continue;
			max = Math.max(max, i - j);
		}
		return max == -1 ? 0 : max;
	}
}
