package com.crackingthecodinginterview;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {

	public boolean checkPermutation(String str1, String str2) {
		if (str1 == null && str2 == null)
			return true;
		if (str1.length() != str2.length())
			return false;
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (table.containsKey(str1.charAt(i)))
				table.put(str1.charAt(i), table.get(str1.charAt(i)) + 1);
			else
				table.put(str1.charAt(i), 1);
		}

		for (int i = 0; i < str2.length(); i++) {
			if (table.get(str2.charAt(i)) == null)
				return false;
			else {
				table.put(str2.charAt(i), table.get(str2.charAt(i)) - 1);
				if (table.get(str2.charAt(i)) < 0)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Problem2 sol = new Problem2();
		System.out.println(sol.checkPermutation("nitin", "tinin"));
	}
}
