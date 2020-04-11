package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> output = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int nw_sentence = 0;
		for (String word : words) {
			if (sb.length() + word.length() <= maxWidth) {
				sb.append(word + " ");
				nw_sentence++;
			} else {
				output.add(pad(sb.toString().trim(), maxWidth));
				sb = new StringBuilder();
				sb.append(word + " ");
				nw_sentence = 1;
			}
		}
		String last = sb.toString().trim();
		// System.out.println(last);
		output.add(padSpaces(last, maxWidth - last.length()));
		return output;
	}

	private String padSpaces(String s, int num) {
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		while (num-- > 0)
			sb.append(" ");
		return sb.toString();
	}

	private String pad(String s, int maxWidth) {

		String[] arr = s.split(" ");
		int len = 0;
		for (String w : arr)
			len += w.trim().length();
		int spaces = maxWidth - len;

		StringBuilder sb = new StringBuilder();
		if (arr.length == 1) {
			sb.append(arr[0]);
			while (spaces-- > 0) {
				sb.append(" ");
			}
			return sb.toString();
		}
		int i = 0;
		for (String word : arr) {
			sb.append(word);
			if (arr.length == 1)
				break;
			int p = (int) Math.ceil(spaces / (double) (arr.length - 1 - i++));
			spaces -= p;
			while (p-- > 0) {
				sb.append(" ");
			}
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}
}
