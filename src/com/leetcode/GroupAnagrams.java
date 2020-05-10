package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] inp = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new GroupAnagrams().groupAnagrams(inp);
		for(List<String> l : res){
			for(String s : l)
				System.out.print(s + " ");
			System.out.println();
		}
	}

}
