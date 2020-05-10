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
	
	int global_min = Integer.MAX_VALUE;

	public static int maximumMinimumPath_sg(int[][] A) {
		int mini = Integer.MAX_VALUE;
		boolean[][] visited = new boolean[A.length][A[0].length];
		return findMin(A, 0, 0, mini, visited);
	}

	public static int findMin(int[][] A, int i, int j, int mini, boolean[][] visited) {
		int r = A.length;
		int c = A[0].length;
		if (i >= r || j >= c || i < 0 || j < 0)
			return mini;
		if (visited[i][j])
			return mini;
		if (A[i][j] < mini)
			mini = A[i][j];
		visited[i][j] = true;
		if (i == r - 1 && j == c - 1)
			return mini;
//		int minh = Math.min(mini, A[i][j]);
		return Math.max(Math.max(findMin(A, i + 1, j, mini, visited), findMin(A, i, j + 1, mini, visited)),
				Math.max(findMin(A, i - 1, j, mini, visited), findMin(A, i, j - 1, mini, visited)));
//		if (i < r - 1) {
//			if (j < c - 1) {
//				return Math.max(findMin(A, i + 1, j, mini), findMin(A, i, j + 1, mini));
//			} else {
//				return findMin(A, i + 1, j, mini);
//			}
//		} else if (j < c - 1) {
//			return findMin(A, i, j + 1, mini);
//		}
//		return mini;
	}

	public static void main(String[] args) {
//		int[][] a = { { 2, 2, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 2 } };
		int[][] a = { { 5, 1 }, { 2, 6 } };
//		System.out.println(new PathWithMaximumMinimumValue().maximumMinimumPath(a));
		System.out.println(maximumMinimumPath_sg(a));
	}
}
