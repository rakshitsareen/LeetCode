package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		Queue<int[]> q = new LinkedList<>();
		int fresh = 0;
		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[0].length; ++j)
				if (grid[i][j] == 2) {
					q.offer(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}
		if (fresh == 0)
			return 0;
		int days = 0;
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			days++;
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				int[] point = q.poll();
				for (int[] dir : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];
					if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0)
						continue;
					grid[x][y] = 2;
					q.offer(new int[] { x, y });
					fresh--;
				}
			}
		}
		return fresh == 0 ? days - 1 : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
