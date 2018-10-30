package com.leetcode;

import java.util.HashMap;
import javafx.util.Pair;

public class FindAndReplaceinString {

	public boolean legit(final String source, int index, final String sub) {
		if (source.substring(index, index + sub.length()).equals(sub))
			return true;
		return false;
	}

	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		HashMap<Integer, Pair<String, String>> map = new HashMap<>();
		while (i < indexes.length) {
			if (legit(S, indexes[i], sources[i]))
				map.put(indexes[i], new Pair<String, String>(sources[i], targets[i]));
			i++;
		} // map is populated
		i = 0;
		while (i < S.length()) {
			if (map.get(i) != null) {
				Pair<String, String> tmp = map.get(i);
				sb.append(tmp.getValue());
				i += tmp.getKey().length();
			} else {
				sb.append(S.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String S = "abcd";
		int[] indexes = { 0, 2 };
		String[] sources = { "ab", "ec" };
		String[] targets = { "eee", "ffff" };
		System.out.println(new FindAndReplaceinString().findReplaceString(S, indexes, sources, targets));
	}

}
