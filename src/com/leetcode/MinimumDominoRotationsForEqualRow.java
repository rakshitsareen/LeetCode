package com.leetcode;

public class MinimumDominoRotationsForEqualRow {

	public static int minDominoRotations(int[] A, int[] B) {
		if (A.length == 1)
			return 0;
		int[] freq = new int[7];
		for (int i = 0; i < A.length; ++i) {
			freq[A[i]]++;
			freq[B[i]]++;
		}
		int val = 0;
		for (int i = 0; i < freq.length; ++i) {
			if (freq[i] >= A.length)
				val = i;
		}
		if (val == 0)
			return -1;
		int fA = 0, fB = 0;
		for (int i = 0; i < A.length; ++i) {
			boolean present = false;
			if (A[i] == val) {
				fA++;
				present = true;
			}
			if (B[i] == val) {
				fB++;
				present = true;
			}
			if (!present)
				return -1;
		}
		return A.length - Math.max(fA, fB);
	}

	public static void main(String[] args) {
		int[] A = {2,3,2,1,1,1,2,2};
		int[] B = {2,1,2,1,1,3,1,1};
		/*
		 * [2,3,2,1,1,1,2,2] [2,1,2,1,1,3,1,1] 
		 * [1,2,3,4,6] [6,6,6,6,5]
		 */
		System.out.println(minDominoRotations(A, B));
	}

}
