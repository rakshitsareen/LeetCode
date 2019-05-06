package com.leetcode;

public class WordSearch {

	public boolean dfs(char[][] board, int i, int j, String word, boolean[][] visited) {
		if (word == null || word.length() == 0)
			return true;
		// [i,j-1], [i,j+1],[i-1,j],[i+1,j]
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i][j]) {
			if (board[i][j] == word.charAt(0)) {
				visited[i][j] = true;
				String new_word = word.substring(1);
				// dfs for this new_word
				boolean ans = dfs(board, i, j - 1, new_word, visited) || dfs(board, i, j + 1, new_word, visited)
						|| dfs(board, i - 1, j, new_word, visited) || dfs(board, i + 1, j, new_word, visited);
				visited[i][j] = false;
				return ans;
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return false;
		if (board == null)
			return false;
		int ro = board.length;
		int col = board[0].length;
		boolean[][] visited = new boolean[ro][col];
		for (int i = 0; i < ro; i++)
			for (int j = 0; j < col; j++)
				if (dfs(board, i, j, word, visited))
					return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
