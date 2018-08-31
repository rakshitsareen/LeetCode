package com.crackingthecodinginterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		Arrays.sort(nums);
		int sum = 0;
		int i = 0, j = nums.length - 1;
		while (i < j) {
			sum = nums[i] + nums[j];
			if (sum == target) {
				ans[0] = nums[i];
				ans[1] = nums[j];
				break;
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		return ans;
	}

	public static int[] twoSum2(int[] nums, int target) {
		int[] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) == null) {
				map.put(nums[i], i);
			} else {
				int j = map.get(target - nums[i]);
				if (i < j) {
					ans[0] = i;
					ans[1] = j;
				} else {
					ans[0] = j;
					ans[1] = i;
				}
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int[] ans = TwoSum.twoSum2(nums, 6);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}

}
