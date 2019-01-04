package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> set = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> map = new HashMap<>();
		String[] para = paragraph.replaceAll("\\W+", " ").trim().toLowerCase().split("\\s+");
		for (String ms : para) {
			if (!set.contains(ms)) {
				if (ms.length() > 0) {
					map.put(ms, map.getOrDefault(ms, 0) + 1);
				}
			}
		}
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public static void main(String[] args) {
		String s = "a, a, a, a, b,b,b,c, c";
		String[] banned = { "a" };
		System.out.println(new MostCommonWord().mostCommonWord(s, banned));
	}

}
