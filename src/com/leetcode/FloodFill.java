package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int color = image[sr][sc];
		bfs(image, sr, sc, newColor, color);
		return image;
	}

	int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private void bfs(int[][] img, int i, int j, int ncolor, int ocolor) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		boolean[][] visited = new boolean[img.length][img[0].length];
		img[i][j] = ncolor;
		visited[i][j] = true;
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] dir : dirs) {
				int x = curr[0] + dir[0];
				int y = curr[1] + dir[1];
				if (x < 0 || x >= img.length || y < 0 || y >= img[0].length || visited[x][y] || img[x][y] != ocolor)
					continue;
				img[x][y] = ncolor;
				q.offer(new int[] { x, y });
				visited[x][y] = true;
			}
		}
	}

}
