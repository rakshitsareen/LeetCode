package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		int i = 0;
		while (i < s.length()) {
			if (map.get(s.charAt(i)) == null) { // never seen before
				if (map.values().contains(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
			} else {
				if (t.charAt(i) != map.get(s.charAt(i)))
					return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
	}

}
