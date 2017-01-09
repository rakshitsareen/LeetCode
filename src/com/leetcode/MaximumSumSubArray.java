package com.leetcode;
/*
 * Algorithm doesn't work for all negative numbers. It simply returns 0 if all numbers are negative. For handling this we can add an extra phase before actual implementation. The phase will look if all numbers are negative, if they are it will return maximum of them (or smallest in terms of absolute value). There may be other ways to handle it though.
 * 
 */
public class MaximumSumSubArray {
	public int maxSubArray(int[] arr) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxEndingHere > 0 && maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		MaximumSumSubArray obj = new MaximumSumSubArray();
		int[] arr = { -1 };
		System.out.println(obj.maxSubArray(arr));
	}
}
