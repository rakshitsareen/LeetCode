package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * find 3 numbers in the array which sum to zero.
 * approach : for every entry in the array, do a simple 2Sum sweep to find two numbers
 * with the target sum.
 * The Array has to be sorted first.
 */

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); // takes nlog(n) time
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int minus_a = 0 - nums[i];
			int lo = i + 1;
			int hi = nums.length - 1;
			while (lo < hi) {
				if (nums[lo] + nums[hi] == minus_a) {
					ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
					// We have to move the lo and hi to point so that we do not repeat
					// the array elements
					while (lo < hi && nums[lo] == nums[lo + 1])
						lo++;
					while (lo < hi && nums[hi] == nums[hi - 1])
						hi--;
				} else if (nums[lo] + nums[hi] < minus_a)
					lo++;
				else
					hi--;
			}
		}
		return ans;
	}
	
	public List<List<Integer>> threeSum2(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> sol = ThreeSum.threeSum(arr);
		System.out.println(sol);
	}
}
