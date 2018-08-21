package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return 1;
		int mstreak = 0;
		int n = nums.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i < n; i++) {
			int y = 0, streak = 0;
			// check if nums[i] - 1 is also in set, then claculate
			// the streak ( if yes )
			if (!set.contains(nums[i] - 1)) {
				// then it is the start of a streak.
				y = nums[i]; // save the srart of streak
				while (set.contains(++y)) {
					streak++;
				}
				mstreak = Math.max(mstreak, streak); // update the streak
			}
		}
		return mstreak + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(LongestConsecutiveSequence.longestConsecutive(nums));
	}
}
