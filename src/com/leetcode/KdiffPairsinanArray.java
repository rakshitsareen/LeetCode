package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray {

	public static int findPairs(int[] nums, int k) {
		int count = 0;
		if (nums == null || nums.length == 0 || k < 0)
			return count;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() >= 2)
					count++;
			} else {
				if (map.containsKey(entry.getKey() + k))
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 4, 1, 5 };
		System.out.println(findPairs(nums, 2));
	}

}
