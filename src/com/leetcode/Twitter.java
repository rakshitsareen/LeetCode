package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Twitter {


	public static List<String> _missingWords(String s, String t) {
		List<String> output = new ArrayList<>();
		String[] _s = s.split(" ");
		String[] _t = t.split(" ");
		int k = 0;
		for (int i = 0; i < _t.length; ++i) {
			String in = _t[i];
			while (!_s[k].equals(in) && k < _s.length) {
				k++;
			}
			if (k < _s.length) {
				_s[k] = null;
			}
			k++;
		}
		for (String out : _s) {
			if (out != null)
				output.add(out);
		}
		return output;
	}

	public static void main(String[] args) {
		List<String> ans = _missingWords("I am using HackerRank to improve programming", "am HackerRank to improve");
		for (String a : ans)
			System.out.println(a);
	}

}
