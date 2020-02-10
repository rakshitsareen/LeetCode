package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem {

	public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> res = new ArrayList<List<String>>();
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		Arrays.parallelSort(products);
		List<String> plist = Arrays.asList(products);

		for (int i = 0; i < products.length; ++i)
			map.put(products[i], i);

		String key = "";
		for (char c : searchWord.toCharArray()) {
			key += c;
			String ceiling = map.ceilingKey(key);
			String floor = map.floorKey(key + "~");	
			if (ceiling == null || floor == null)
				break;
			res.add(plist.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
		}
		while (res.size() < searchWord.length())
			res.add(new ArrayList<String>());
		return res;
	}

	private static void printList(List<String> list) {
		for(String s : list)
			System.out.print( s + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		String[] products = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		suggestedProducts(products, "mouse").forEach(list -> printList(list));

	}

}
