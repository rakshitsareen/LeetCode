package com.leetcode;

public class NumberOfIslands {

	private int sink(int i, int j, char[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return 0;
		grid[i][j] = '0';
		sink(i + 1, j, grid);
		sink(i, j + 1, grid);
		sink(i - 1, j, grid);
		sink(i, j - 1, grid);
		return 1;
	}

	public int numIslands(char[][] grid) {
		int islands = 0;
		for (int i = 0; i < grid.length; ++i)
			for (int j = 0; j < grid[i].length; ++j)
				islands += sink(i, j, grid);
		return islands;
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new NumberOfIslands().numIslands(grid));
	}

	/*
	 * public int sink(int i, int j, char[][] grid) { if (i < 0 || i == grid.length
	 * || j < 0 || j == grid[i].length || grid[i][j] == '0') return 0; grid[i][j] =
	 * '0'; // sink this island sink(i + 1, j, grid); sink(i, j + 1, grid); sink(i -
	 * 1, j, grid); sink(i, j - 1, grid); return 1; }
	 * 
	 * public int numIslands(char[][] grid) { int islands = 0; for (int i = 0; i <
	 * grid.length; i++) for (int j = 0; j < grid[i].length; j++) islands += sink(i,
	 * j, grid); return islands; }
	 */
}
