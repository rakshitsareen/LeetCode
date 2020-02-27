package com.leetcode;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumValue {

	int m, n;
	int[] dr = new int[] { 1, -1, 0, 0 };
	int[] dc = new int[] { 0, 0, 1, -1 };

	public int maximumMinimumPath(int[][] A) {
		m = A.length;
		if (m != 0)
			n = A[0].length;
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> A[b[0]][b[1]] - A[a[0]][a[1]]);
		boolean[][] visited = new boolean[m][n];
		heap.offer(new int[] { 0, 0, A[0][0] });
		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			visited[curr[0]][curr[1]] = true;
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr == m - 1 && nc == n - 1)
					return Math.min(curr[2], A[nr][nc]);
				if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
					int ns = A[nr][nc];
					heap.offer(new int[] { nr, nc, Math.min(curr[2], ns) });
				}
			}
		}
		return 0;
	}

}
