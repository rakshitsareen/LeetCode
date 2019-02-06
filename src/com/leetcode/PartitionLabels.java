package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

	public List<Integer> partitionLabels(String str) {
		List<Integer> output = new ArrayList<>();
		if (str.length() == 1) {
			output.add(1);
			return output;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), i);
		}
		int start = 0;
		int last = 0;

		while (last < str.length() && start < str.length()) {
			last = Math.max(last, map.get(str.charAt(start)));
			int i = start + 1;
			while (i <= last) {
				last = Math.max(last, map.get(str.charAt(i)));
				i++;
			}
			output.add(last - start + 1);
			start = last + 1;
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "ababcbacadefegdehijhklij";
		String s = "b";
		System.out.println(new PartitionLabels().partitionLabels(s));
	}

}
