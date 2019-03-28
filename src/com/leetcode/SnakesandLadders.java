package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesandLadders {

	public int snakesAndLadders(int[][] board) {
		int N = board[0].length;
		int move = 0;
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int num = q.poll();
				if (visited.contains(num))
					continue;
				visited.add(num);
				if (N * N == num)
					return move;
				for (int i = 1; i <= 6 && num + i <= N * N; i++) {
					int next = num + i;
					int value = getBoardValue(board, next);
					if (value > 0)
						next = value;
					if (!visited.contains(next))
						q.offer(next);
				}
			}
			move++;
		}
		return -1;
	}

	private int getBoardValue(int[][] board, int num) {
		int n = board.length;
		int r = (num - 1) / n;
		int x = n - 1 - r;
		int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
		return board[x][y];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
