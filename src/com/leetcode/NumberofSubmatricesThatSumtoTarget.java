package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {
	public int numSubmatrixSumTarget(int[][] A, int target) {
		int m = A.length;
		int n = A[0].length;
		int res = 0;
		for (int i = 0; i < m; i++)
			for (int j = 1; j < n; ++j)
				A[i][j] += A[i][j - 1];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				int cur = 0;
				map.clear();
				map.put(0, 1);
				for (int k = 0; k < m; ++k) {
					cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
					res += map.getOrDefault(cur - target, 0);
					map.put(cur, map.getOrDefault(cur, 0) + 1);
				}
			}
		}
		return res;
	}
}
