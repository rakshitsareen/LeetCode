package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	static class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; ++i){
			for(int j = 0; j < board[0].length; ++j){
				dfs(root, i, j, board, res);
			}
		}
		return res;
	}

	public void dfs(TrieNode root, int i, int j, char[][] board, List<String> res){
		char letter = board[i][j];
		if(letter == '#' || root.next[letter - 'a'] == null) return;
		root = root.next[letter - 'a'];
		if(root.word != null){
			res.add(root.word);
			root.word = null;
		}
		board[i][j] = '#';
		if(i > 0) dfs(root, i - 1, j, board, res);
		if(j > 0) dfs(root, i, j - 1, board, res);
		if(i < board.length - 1) dfs(root, i + 1, j, board, res);
		if(j < board[0].length - 1) dfs(root, i, j + 1, board, res);
		board[i][j] = letter;
	}

	public TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String w : words){
			TrieNode p = root;
			for(Character character : w.toCharArray()){
				if(p.next[character - 'a'] == null) p.next[character - 'a'] = new TrieNode();
				p = p.next[character - 'a'];
			}
			p.word = w;
		}
		return root;
	}
}
