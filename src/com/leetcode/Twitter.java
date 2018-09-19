package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Twitter {

	public static List<String> missingWords(String s, String t) {
		List<String> output = new ArrayList<>();
		if (s == null)
			return null;
		String[] _s = s.split(" ");
		if (t == null || t.length() == 0) {
			for (String g : _s) {
				if (g.trim().length() == 0)
					continue;
				output.add(g);
			}
			return output;
		}
		// t is subsequence of s .
		if (_s.length == 0)
			return new ArrayList<>();
		String[] _t = t.split(" ");
		Set<String> superset = new LinkedHashSet<>();
		for (String res : _s) {
			if (res.trim().length() == 0)
				continue;
			superset.add(res);
		}
		// superset.addAll(Arrays.asList(_s));
		for (String subsequence : _t) {
			if (subsequence.trim().length() == 0)
				continue;
			superset.remove(subsequence);
		}
		for (String result : superset) {
			output.add(result.trim());
		}
		return output;
	}

	public static void main(String[] args) {
		List<String> ans = missingWords("I love programming also", "love Also");
		for (String a : ans)
			System.out.println(a);
	}

}
