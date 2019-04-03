package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

	int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public void solve(char[][] board) {
		Queue<int[]> q = new LinkedList<>();
		// Add all O's on the edges
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1 && board[i][j] == 'O')
					q.add(new int[] { i, j });
		// from all the O's on the edges, mark all reachable O's as D
		while (!q.isEmpty()) {
			int arr[] = q.poll();
			int curr_x = arr[0], curr_y = arr[1];
			if (0 <= curr_x && curr_x < board.length && 0 <= curr_y && curr_y < board[0].length
					&& board[curr_x][curr_y] == 'O') {
				board[curr_x][curr_y] = 'D';
				for (int p = 0; p < 4; p++) {
					// generate neighbors and add to the queue
					int x = curr_x + dir[p][0];
					int y = curr_y + dir[p][1];
					q.add(new int[] { x, y });
				}
			}
		}

		// now all nodes which are O's which start from edges have been marked as D's
		// now the remaining O's are the ones which are purely in the interior.
		// so now mark them as X's and the D's as O's back
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == 'D')
					board[i][j] = 'O';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
