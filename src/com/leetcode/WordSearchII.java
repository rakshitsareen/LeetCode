package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < words.length; ++i)
			for (int j = 0; j < words[0].length(); ++j)
				dfs(board, i, j, root, res);
		return res;
	}

	private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) {
			res.add(p.word);
			p.word = null;
		}
		board[i][j] = '#';

		if (i > 0)
			dfs(board, i - 1, j, p, res);
		if (j > 0)
			dfs(board, i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res);
		board[i][j] = c;
	}

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				if (p.next[c - 'a'] == null)
					p.next[c - 'a'] = new TrieNode();
				p = p.next[c - 'a'];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}

}
