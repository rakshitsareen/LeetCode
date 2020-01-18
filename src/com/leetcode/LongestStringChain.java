package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	public static int longestStrChain(String[] words) {
		int longest = 0;
		Map<String, Integer> dp = new HashMap<String, Integer>();
		Arrays.stream(words).forEach(word -> dp.putIfAbsent(word, 1));
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		for (String word : words) {
			for (int i = 0; i < word.length(); ++i) {
				String prev = word.substring(0, i) + word.substring(i + 1);
				if (dp.containsKey(prev))
					dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
			}
			longest = Math.max(longest, dp.get(word));
		}
		return longest;
	}

	public static void main(String[] args) {
		String[] A = { "bdca", "a", "b", "ba", "bca", "bda" };
		long start = System.nanoTime();
		System.out.println(longestStrChain(A));
		long end = System.nanoTime();
		System.out.println((end - start) / 1e6 + " ms");
	}

}
