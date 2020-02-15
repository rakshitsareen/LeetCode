package com.leetcode;

import java.util.Arrays;

public class MoveZeroes {

	// moving zeroes maintaining non zero elements order
	public static void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0) return;
		int idx = 0;
		for(int num : nums) {
			if(num != 0) nums[idx++] = num;
		}
		while(idx < nums.length) nums[idx++] = 0;
	}

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
	}

}

// just moving zeros

//int i = 0, j = nums.length - 1;
//while (i < j) {
//	while (nums[i] != 0) i++;
//	while (nums[j] == 0) j--;
//	int temp = nums[i];
//	nums[i] = nums[j];
//	nums[j] = temp;
//    i++;--j;
//}

