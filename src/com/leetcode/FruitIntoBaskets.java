package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

	public static int totalFruit(int[] tree) {
		if (tree == null)
			return 0;
		if (tree.length == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>(); // map to save indices of types encountered. will save latest
														// indices of types encountered.
		int leftmost = 0, rightmost = 0, maxlen = 0, start = 0;
		while (rightmost < tree.length) {
			if (map.size() <= 2) {
				map.put(tree[rightmost], rightmost);
				rightmost++;
			}
			if (map.size() > 2) {
				leftmost = tree.length;
				for (int i : map.values())
					leftmost = Math.min(leftmost, i);
				map.remove(tree[leftmost]);
				start = leftmost + 1;
			}
			maxlen = Math.max(maxlen, rightmost - start);
		}
		return maxlen;
	}
	public static int totalFruit2(int[] tree) {
		int res = 0;
		int i = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int j = 0 ; j < tree.length; j++){
			map.put(tree[j], map.getOrDefault(tree[j],0) + 1);
			while(map.size() > 2){
				map.put(tree[i], map.get(tree[i]) - 1);
				if(map.get(tree[i]) == 0) map.remove(tree[i]);
				i++;
			}
			res = Math.max(res,j-i+1);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] tree = { 1, 2, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		System.out.println(totalFruit(tree));
	}

}
