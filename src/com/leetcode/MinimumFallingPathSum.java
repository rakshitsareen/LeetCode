package com.leetcode;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public int minFallingPathSum(int[][] A) {
		for (int i = 1; i < A.length; i++)
			for (int j = 0; j < A.length; j++)
				A[i][j] += Math.min(A[i - 1][j],
						Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
		return Arrays.stream(A[A.length -1]).min().getAsInt();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
