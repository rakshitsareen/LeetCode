package com.leetcode;

public class SearchinRotatedSortedArray {

	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[hi])
				lo = mid + 1;
			else
				hi = mid;
		}
		int rot = lo;
		lo = 0;
		hi = nums.length;
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int realmid = (mid + rot) % nums.length;
			if (nums[realmid] == target)
				return realmid;
			if (nums[realmid] < target)
				lo = mid + 1;
			else
				hi = mid;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(nums, 6));
	}

}
