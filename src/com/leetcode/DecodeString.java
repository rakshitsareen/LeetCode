package com.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DecodeString {

	public String wrong_decodeString_wrong(String s) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		int i = 0;
		while (i < s.length()) {
			StringBuilder str = new StringBuilder();
			while (Character.isDigit(s.charAt(i))) {
				str.append(s.charAt(i));
				i++;
			}
			int num = Integer.parseInt(str.toString());
			i++; // skip the '['
			str = new StringBuilder();
			while (s.charAt(i) != ']') {
				str.append(s.charAt(i));
				i++;
			}
			i++;
			map.put(num, str.toString());
		}
		StringBuilder str = new StringBuilder();
		Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> pair = it.next();
			for (int p = pair.getKey(); p > 0; p--)
				str.append(pair.getValue());
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String s = "3[a]2[bc]6[wwe]";
		System.out.println(new DecodeString().wrong_decodeString_wrong(s));
	}

}
