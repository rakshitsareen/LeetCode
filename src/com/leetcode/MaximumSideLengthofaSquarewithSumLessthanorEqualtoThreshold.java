package com.leetcode;

public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {
	int m, n;

	public int maxSideLength(int[][] mat, int threshold) {
		m = mat.length;
		n = mat[0].length;
		int[][] sum = new int[m + 1][n + 1];
		for (int i = 1; i <= m; ++i)
			for (int j = 1; j <= n; ++j)
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
		int lo = 0, hi = Math.min(m, n);
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (squareExists(sum, threshold, mid))
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return hi;
	}

	private boolean squareExists(int[][] sum, int threshold, int index) {
		for (int i = index; i <= m; ++i)
			for (int j = index; j <= n; ++j)
				if (sum[i][j] - sum[i - index][j] - sum[i][j - index] + sum[i - index][j - index] <= threshold)
					return true;
		return false;
	}
}
