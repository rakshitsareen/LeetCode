package com.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

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

	public String decodeString(String s) {
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> resStack = new Stack<String>();
		String res = "";
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = count * 10 + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			}

			else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int count = countStack.pop();
				for (int i = 0; i < count; ++i)
					temp.append(res);
				res = temp.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "3[a5[pc]]2[bc]6[d]";
		System.out.println(new DecodeString().decodeString(s));
	}
}
