package com.crackingthecodinginterview;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UniqueSubstrings {

	static String[] uniqueSubstrings(String inputString, int substringLength) {
		Set<String> s = new TreeSet<>();
		for (int i = 0; i < inputString.length() - substringLength + 1; i++) {
			String sub = inputString.substring(i, i + substringLength);
			s.add(sub);
		}
		String[] ans = new String[s.size()];
		Iterator<String> itr = s.iterator();
		int i = 0;
		while (itr.hasNext()) {
			ans[i] = itr.next();
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String[] ans = uniqueSubstrings("zacaabc", 3);
		for (String s : ans)
			System.out.println(s);
	}
}
