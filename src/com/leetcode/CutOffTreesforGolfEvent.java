package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTreesforGolfEvent {

	int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int cutOffTree(List<List<Integer>> forest) {
		if (forest == null || forest.size() == 0)
			return -1;
		int m = forest.size(), n = forest.get(0).size();
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (forest.get(i).get(j) > 1)
					list.add(new int[] { forest.get(i).get(j), i, j });
		Collections.sort(list, Comparator.comparingInt(o -> o[0]));
		int start_x = 0, start_y = 0;
		int steps = -1;
		int output = 0;
		for (int i = 0; i < list.size(); i++) {
			steps = BFS(forest, m, n, start_x, start_y, list.get(i)[1], list.get(i)[2]);
			if (steps == -1)
				return -1;
			output += steps;
			start_x = list.get(i)[1];
			start_y = list.get(i)[2];
		}
		return output;
	}

	private int BFS(List<List<Integer>> forest, int m, int n, int start_x, int start_y, int des_x, int des_y) {
		if (start_x == des_x && start_y == des_y)
			return 0;
		int steps = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { start_x, start_y });
		int[][] visited = new int[m][n];
		visited[start_x][start_y] = 1;
		while (!queue.isEmpty()) {
			steps++;
			int qsize = queue.size();
			while (qsize-- > 0) { // only process elements in the current level
				int[] arr = queue.poll();
				int curr_x = arr[0], curr_y = arr[1];
				for (int p = 0; p < 4; p++) {
					int x = curr_x + dir[p][0];
					int y = curr_y + dir[p][1];
					if (x >= 0 && x < m && y >= 0 && y < n && forest.get(x).get(y) > 0 && visited[x][y] == 0) {// ifvalid

						if (x == des_x && y == des_y)
							return steps;
						visited[x][y] = 1;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
