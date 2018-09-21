package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter {

	static class Pair {
		Integer x;
		Integer y;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((x == null) ? 0 : x.hashCode());
			result = prime * result + ((y == null) ? 0 : y.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x == null) {
				if (other.x != null)
					return false;
			} else if (!x.equals(other.x))
				return false;
			if (y == null) {
				if (other.y != null)
					return false;
			} else if (!y.equals(other.y))
				return false;
			return true;
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int sink(int i, int j, char[][] grid, Set<Pair> set) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
			return 0;
		grid[i][j] = '0'; // sink this island
		set.add(new Twitter.Pair(i, j));
		sink(i + 1, j, grid, set);
		sink(i, j + 1, grid, set);
		sink(i - 1, j, grid, set);
		sink(i, j - 1, grid, set);
		return 1;
	}

	public static Map<Twitter.Pair, Set<Twitter.Pair>> numIslands(char[][] grid) {
		int island = 0;
		LinkedHashMap<Twitter.Pair, Set<Twitter.Pair>> regions = new LinkedHashMap<>();
		Set<Twitter.Pair> temp = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				island = sink(i, j, grid, temp);
				if (island != 0) {
					regions.put(new Twitter.Pair(i, j), temp);
					temp = new HashSet<>();
				}
			}
		}
		return regions;
	}

	public static int countMatches(List<String> grid1, List<String> grid2) {
		if (grid1 == null)
			return 0;
		if (grid2 == null)
			return 0;
		char[][] gridOne = new char[grid1.size()][grid1.get(0).length()];
		char[][] gridTwo = new char[grid2.size()][grid2.get(0).length()];
		int i = 0, j = 0;
		for (String row : grid1) {
			j = 0;
			while (j < row.length()) {
				gridOne[i][j] = row.charAt(j);
				j++;
			}
			i++;
		}
		i = 0;
		j = 0;
		for (String row : grid2) {
			j = 0;
			while (j < row.length()) {
				gridTwo[i][j] = row.charAt(j);
				j++;
			}
			i++;
		}
		Map<Twitter.Pair, Set<Twitter.Pair>> g1 = numIslands(gridOne);
		Map<Twitter.Pair, Set<Twitter.Pair>> g2 = numIslands(gridTwo);
		int regions = 0;
		for (Map.Entry<Twitter.Pair, Set<Twitter.Pair>> entry : g1.entrySet()) {
			Twitter.Pair key = entry.getKey();
			Set<Twitter.Pair> val = entry.getValue();
			if (g2.get(key) != null) {
				// match the regions
				Set<Twitter.Pair> val2 = g2.get(key);
				if (matchRegions(val, val2)) {
					regions++;
				}
			}
		}
		return regions;
	}

	public static boolean matchRegions(Set<Twitter.Pair> p1, Set<Twitter.Pair> p2) {
		if (p1.size() != p2.size())
			return false;
		if (p1.equals(p2))
			return true;
		if (p1.containsAll(p2) && p2.containsAll(p1))
			return true;
		return false;
	}

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

	public static List<Integer> minimalOperations(List<String> words) {
		if (words == null)
			return null;
		List<Integer> result = new ArrayList<>();
		for (String word : words) {
			int len = word.length();
			int index = 0;
			int changes = 0;
			while (index < len - 1) {
				int no_of_consecutive_chars = 1;
				while (index < len - 1 && word.charAt(index) == word.charAt(index - 1)) {
					no_of_consecutive_chars += 1;
					index += 1;
				}
				changes = (int)no_of_consecutive_chars/2;
				index +=1;
			}
			result.add(changes);
		}
		return result;
	}

	public static void main(String[] args) {
		// List<String> ans = _missingWords("I am using HackerRank to improve
		// programming", "am HackerRank to improve");
		// for (String a : ans)
		// System.out.println(a);
		List<String> g1 = new ArrayList<>();
		g1.add("0100");
		g1.add("1001");
		g1.add("0011");
		g1.add("0011");
		List<String> g2 = new ArrayList<>();
		g2.add("0101");
		g2.add("1001");
		g2.add("0011");
		g2.add("0011");
		int ans = countMatches(g1, g2);
		System.out.println(ans);
	}

}
