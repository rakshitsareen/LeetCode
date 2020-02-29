package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int output = 0;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					helper(grid, i, j, 0, 0, sb);
					if (!set.contains(sb.toString())) {
						set.add(sb.toString());
						output++;
					}
				}
			}
		}
		return output;
	}

	private void helper(int[][] grid, int i, int j, int x, int y, StringBuilder sb) {
		grid[i][j] = 0;
		sb.append(x + "" + y);
		for (int[] dir : dirs) {
			int a = i + dir[0];
			int b = j + dir[1];
			if (a < 0 || a > grid.length - 1 || b < 0 || b > grid[0].length - 1 || grid[a][b] == 0)
				continue;
			helper(grid, a, b, x + dir[0], y + dir[1], sb);
		}
	}

}
