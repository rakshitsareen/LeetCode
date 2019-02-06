package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class MyPair {
	String s;
	int step;

	public MyPair(String s, int pos) {
		this.s = s;
		this.step = pos;
	}
}

public class WordLadder {

	char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<String>();
		Queue<MyPair> queue = new LinkedList<>();
		visited.add(beginWord);
		queue.add(new MyPair(beginWord, 1));
		while (!queue.isEmpty()) {
			MyPair p = queue.poll();
			String considering = p.s;
			int step = p.step;
			for (int i = 0; i < considering.length(); i++) {
				for (char c : alphabet) {
					String newString = considering.substring(0, i) + Character.toString(c)
							+ considering.substring(i + 1, considering.length());
					// System.out.println(newString);
					if (dict.contains(newString) && !visited.contains(newString)) {
						visited.add(newString);
						if (newString.equals(endWord))
							return step + 1;
						queue.add(new MyPair(newString, step + 1));
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		// "hot","dot","dog","lot","log","cog"
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
	}

}
