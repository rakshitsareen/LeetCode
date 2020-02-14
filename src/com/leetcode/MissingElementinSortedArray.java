package com.leetcode;

public class MissingElementinSortedArray {

	public static int missingElement(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = (left + right) / 2;
			int temp = nums[mid] - nums[left] - (mid - left);
			if (temp >= k) {
				right = mid;
			} else {
				k = k - temp;
				left = mid;
			}
		}
		if (nums[left] + k >= nums[right])
			return nums[left] + k + 1;
		return nums[left] + k;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 7, 9, 10 };
		System.out.println(missingElement(nums, 3));
	}

}
