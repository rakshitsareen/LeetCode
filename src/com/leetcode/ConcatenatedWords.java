package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		Set<String> dict = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			if (canForm(word, dict)) {
				if (word.length() > 0)
					result.add(word);
			}
			dict.add(word);
		}
		return result;
	}

	public static boolean canForm(String word, Set<String> dict) {
		if (word.length() == 0)
			return true;
		if(dict.isEmpty()) return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (dp[j] && dict.contains(word.substring(j, i))) {
					dp[i] = true;
					continue;
				}
			}
		}
		return dp[word.length()];
	}

	public static void main(String[] args) {
//		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		String[] words = { "" };
		System.out.println(findAllConcatenatedWordsInADict(words));
	}

}
