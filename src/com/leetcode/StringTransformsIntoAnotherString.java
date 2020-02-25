package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {

	public boolean canConvert(String str1, String str2) {
		if (str1 == null && str2 == null)
			return true;
		if (str1 == null || str2 == null)
			return false;
		if(str1.equals(str2)) return true;
		Map<Character, Character> graph = new HashMap<Character, Character>();
		for (int i = 0; i < str1.length(); ++i) {
			if (!graph.containsKey(str1.charAt(i)))
				graph.put(str1.charAt(i), str2.charAt(i));
			else if (graph.get(str1.charAt(i)) != str2.charAt(i)) // two different types of mappings found
				return false;
		}
		if(graph.keySet().size() == new HashSet<Character>(graph.values()).size())
			return graph.size() != 26;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
