package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SortCharactersByFrequency {

	class Pair implements Comparable<Pair> {
		Character c;
		Integer freq;

		public Pair(Character c, int freq) {
			this.c = c;
			this.freq = freq;
		}

		@Override
		public int compareTo(Pair o) {
			int res = o.freq - freq;
			if (res != 0)
				return res;
			else {
				return 1;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			result = prime * result + freq;
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			if (freq != other.freq)
				return false;
			return true;
		}

		public String toString() {
			return new String(this.c + " : " + this.freq);
		}

		private SortCharactersByFrequency getOuterType() {
			return SortCharactersByFrequency.this;
		}

	}

	public String frequencySort(String s) {
		Set<Pair> set = new TreeSet<>();
		Map<Character, Integer> map = new HashMap<>();
		int i = s.length() - 1;
		while (i >= 0) {
			if (map.get(s.charAt(i)) == null)
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			i--;
		}
		Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Integer> pair = it.next();
			set.add(new Pair(pair.getKey(), pair.getValue()));
		}
		return buildString(set);
	}

	public String buildString(Set<Pair> set) {
		StringBuilder str = new StringBuilder();
		for (Pair p : set) {
			for (int i = p.freq; i > 0; i--)
				str.append(p.c);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String s = "tree";
		System.out.println(new SortCharactersByFrequency().frequencySort(s));
	}

	public String frequencySort2(String s) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> f = new HashMap<Character, Integer>();

		for (char c : s.toCharArray()) {
			f.put(c, f.getOrDefault(c, 0) + 1);
		}

		ArrayList<Character>[] b = new ArrayList[s.length() + 1];
		for (char c : f.keySet()) {
			int fr = f.get(c);
			if (b[fr] == null)
				b[fr] = new ArrayList<Character>();
			b[fr].add(c);
		}
		for (int pos = b.length - 1; pos >= 0; pos--) {
			if (b[pos] != null) {
				for (char c : b[pos]) {
					for (int i = 0; i < f.get(c); ++i)
						sb.append(c);
				}
			}
		}

		return sb.toString();
	}

}
