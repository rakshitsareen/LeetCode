package com.leetcode;

public class TrappingRainWater {

	public static int trap(int[] A) {
		int left = 0, right = A.length - 1;
		int maxleft = 0, maxright = 0;
		int res = 0;
		while (left <= right) {
			if (A[left] <= A[right]) {
				if (A[left] >= maxleft)
					maxleft = A[left];
				else
					res += maxleft - A[left];
				left++;
			} else {
				if (A[right] >= maxright)
					maxright = A[right];
				else
					res += maxright - A[right];
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 1, 2, 3, 4, 5 }));
	}

}
