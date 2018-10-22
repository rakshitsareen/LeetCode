package com.leetcode;

public class BricksFallingWhenHit {
	int[][] g = null;
	int id = 0;
	int[][] vst = new int[201][201];
	int[] dr = { -1, 0, 1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	public boolean valid(int r, int c) {
		if (0 >= r || r >= g.length || 0 >= c || c >= g[0].length)
			return false;
		return true;
	}

	public boolean falling(int r, int c) {
		if (!valid(r, c) || g[r][c] == 0)
			return true;
		if (vst[r][c] == id)
			return true; // already visited in this pass
		if (r == 0)
			return false;
		vst[r][c] = id;
		for (int i = 0; i < 4; i++) {
			r = r + dr[i]; // add delta to row
			c = c + dc[i]; // add delta to col
			if (!falling(r, c))
				return false;
		}
		return true;
	}

	public int cnt(int r, int c) {
		if (!valid(r, c) || g[r][c] == 0)
			return 0;
		int ans = 1;
		g[r][c] = 0;
		for (int d = 0; d < 4; d++) {
			ans += cnt(r + dr[d], c | dc[d]);
		}
		return ans;
	}

	public int[] hitBricks(int[][] grid, int[][] hits) {
		g = grid;
		int[] res = new int[hits.length];
		int k = 0;
		for (int[] h : hits) {
			int nfall = 0;
			int x = h[0];
			int y = h[1];
			if (g[x][y] == 1) {
				g[x][y] = 0;
				vst[x][y] = id;
				for (int d = 0; d < 4; d++) {
					if (!valid(x + dr[d], y + dc[d]) || g[x + dr[d]][y + dc[d]] == 0)
						continue; // hit at wrong place, continue
					id++;
					if (falling(x + dr[d], y + dc[d]))
						nfall += cnt(x + dr[d], y + dc[d]);
				}
			}
			res[k++] = nfall;
		}
		return res;
	}

	public static void main(String[] args) {
	}

}
