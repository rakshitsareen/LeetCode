package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Queue<int[]> pqueue = new LinkedList<int[]>();
		Queue<int[]> aqueue = new LinkedList<int[]>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return output;
        }
		int n = matrix.length, m = matrix[0].length;
		boolean[][] pvisited = new boolean[matrix.length][matrix[0].length];
		boolean[][] avisited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < n; ++i) {
			pqueue.offer(new int[] { i, 0 });
			aqueue.offer(new int[] { i, m - 1 });
			avisited[i][m - 1] = true;
			pvisited[i][0] = true;
		}

		for (int i = 0; i < m; i++) {
			pqueue.offer(new int[] { 0, i });
			aqueue.offer(new int[] { n - 1, i });
			pvisited[0][i] = true;
			avisited[n - 1][i] = true;
		}
		bfs(matrix, pqueue, pvisited);
		bfs(matrix, aqueue, avisited);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pvisited[i][j] && avisited[i][j]) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					output.add(temp);
				}
			}
		}

		return output;
	}

	public void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
		int n = matrix.length, m = matrix[0].length;
		int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			for (int[] d : dir) {
				int x = cur[0] + d[0];
				int y = cur[1] + d[1];
				if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
					continue;
				}
				visited[x][y] = true;
				queue.offer(new int[] { x, y });
			}
		}
	}

}
