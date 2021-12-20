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

	public int numOfIslandUnionFind(char[][] grid){
		if (grid == null || grid.length == 0 || grid[0].length == 0)  {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		UnionFind unionFind = new UnionFind(grid);
		int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <n; j++) {
				if(grid[i][j] == '1'){
					for(int[] dir : dirs){
						int x = i + dir[0];
						int y = j + dir[1];
						if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == '1') {
							int id1 = i * n + j;
							int id2 = x * n + y;
							unionFind.union(id1, id2);
						}
					}
				}
			}
		}
		return unionFind.count;
	}
}

class UnionFind{
	int[] parent;
	int count;

	public UnionFind(char[][]grid){
		int m = grid.length;
		int n = grid[0].length;
		parent = new int[m*n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == '1'){
					count++;
					int id = i * n + j;
					parent[id] = id;
				}
			}
		}
	}

	public int find(int x){
		if(parent[x] == x) return x;
		parent[x] = find(parent[x]);
		return parent[x];
	}

	public void union(int x, int y){
		int i = find(x);
		int j = find(y);
		if(i != j){
			parent[i] = j;
			count--;
		}
	}
}
