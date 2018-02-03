package com.leetcode;

/*
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
 */
public class SingleElementInASortedArray {

	public static int singleElementUtil(int[] nums, int start, int end) {
		if (start == end)
			return nums[start];
		int mid = (start + end) / 2;
		if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
			return nums[mid];
		}
		if ((nums[mid] == nums[mid - 1] && mid % 2 == 1) || (nums[mid] == nums[mid + 1] && mid % 2 == 0)) {
			start = mid + 1;
		} else
			end = mid - 1;
		return singleElementUtil(nums, start, end);
	}

	public static int singleElement(int[] nums) {
		if (nums == null)
			return -1;
		if (nums.length == 1)
			return nums[0];
		return singleElementUtil(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		// int[] nums = { 3, 3, 7, 7, 10, 11, 11 };
		// int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		// int[] nums = { 1, 1, 2 };
		int[] nums = { 1, 1, 2, 2, 4, 4, 5, 5, 9 };
		System.out.println(SingleElementInASortedArray.singleElement(nums));
	}

}
