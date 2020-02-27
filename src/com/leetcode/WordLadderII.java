package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		ArrayList<String> solution = new ArrayList<String>();
		HashSet<String> dict = new HashSet<String>(wordList);
		dict.add(beginWord);
		bfs(beginWord, endWord, dict, map, distance);
		dfs(beginWord, endWord, dict, map, distance, solution, res);
		return res;
	}

	private void bfs(String start, String end, HashSet<String> dict, Map<String, ArrayList<String>> map,
			Map<String, Integer> distance) {
		for (String str : dict)
			map.put(str, new ArrayList<String>());
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		distance.put(start, 0);
		while (!q.isEmpty()) {
			int size = q.size();
			boolean found = false;
			for (int i = 0; i < size; i++) {
				String curr = q.poll();
				int curDistance = distance.get(curr);
				ArrayList<String> neighbors = getNeighbors(curr, dict);
				for (String neighbor : neighbors) {
					map.get(curr).add(neighbor);
					if (!distance.containsKey(neighbor)) {
						distance.put(neighbor, curDistance + 1);
						if (end.equals(neighbor))
							found = true;
						else
							q.offer(neighbor);
					}
				}
			}
			if (found)
				break;
		}
	}

	private ArrayList<String> getNeighbors(String node, HashSet<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char[] chs = node.toCharArray();
		for (char ch = 'a'; ch <= 'z'; ++ch) {
			for (int i = 0; i < chs.length; ++i) {
				char old = chs[i];
				chs[i] = ch;
				if (dict.contains(String.valueOf(chs)))
					res.add(String.valueOf(chs));
				chs[i] = old;
			}
		}
		return res;
	}

	private void dfs(String node, String end, HashSet<String> dict, Map<String, ArrayList<String>> map,
			Map<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
		solution.add(node);
		if (end.equals(node))
			res.add(new ArrayList<String>(solution));
		else {
			for (String next : map.get(node)) {
				if (distance.get(next) == distance.get(node) + 1)
					dfs(next, end, dict, map, distance, solution, res);
			}
		}
		solution.remove(solution.size() - 1);
	}

}
