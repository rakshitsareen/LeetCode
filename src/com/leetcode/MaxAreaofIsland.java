package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaofIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int output = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; ++j)
				if (grid[i][j] == 1)
					output = Math.max(output, bfs(grid, i, j));
		return output;
	}

	private int bfs(int[][] grid, int i, int j) {
		int output = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		grid[i][j] = 0;
		q.offer(new int[] { i, j });
		output++;
		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				if (x < grid.length && y < grid[0].length && x >= 0 && y >= 0 && grid[x][y] == 1) {
					output++;
					q.offer(new int[] { x, y });
					grid[x][y] = 0; // visited
				}
			}
		}
		return output;
	}

}
