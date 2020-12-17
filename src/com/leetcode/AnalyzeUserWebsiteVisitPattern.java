package com.leetcode;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern {
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		List<List<String>> sessions = new ArrayList<List<String>>();
		int n = timestamp.length;
		for (int i = 0; i < n; ++i) {
			sessions.add(new ArrayList<>());
			sessions.get(i).add(username[i]);
			sessions.get(i).add("" + timestamp[i]);
			sessions.get(i).add(website[i]);
		}
		sessions.sort((a, b) -> Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));

		Map<String, List<String>> visits = new HashMap<>();
		for (int i = 0; i < n; ++i) {
			visits.putIfAbsent(sessions.get(i).get(0), new ArrayList<>());
			visits.get(sessions.get(i).get(0)).add(sessions.get(i).get(2));
		}

		Map<String, Integer> freq = new HashMap<>();
		int max = Integer.MIN_VALUE;
		String seq = null;
		for (String name : visits.keySet()) {
			Set<String> subs = generatesubs(visits.get(name));
			for (String sub : subs) {
				freq.put(sub, freq.getOrDefault(sub, 0) + 1);
				if (freq.get(sub) > max) {
					max = freq.get(sub);
					seq = sub;
				} else if (freq.get(sub) == max && sub.compareTo(seq) < 0)
					seq = sub;
			}
		}

		String[] ans = seq.split(",");
		return new ArrayList<>(Arrays.asList(ans));
	}

	public Set<String> generatesubs(List<String> list) {
		int n = list.size();
		Set<String> res = new HashSet<>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					res.add(list.get(i) + "," + list.get(j) + "," + list.get(k));
				}
			}
		}
		return res;
	}
}
