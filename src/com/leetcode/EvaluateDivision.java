package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, List<String>> pairs = new HashMap<>();
		Map<String, List<Double>> vals = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String[] eq = equations[i];
			if (!pairs.containsKey(eq[0])) {
				pairs.put(eq[0], new ArrayList<>());
				vals.put(eq[0], new ArrayList<>());
			}
			if (!pairs.containsKey(eq[1])) {
				pairs.put(eq[1], new ArrayList<>());
				vals.put(eq[1], new ArrayList<>());
			}
			pairs.get(eq[0]).add(eq[1]);
			vals.get(eq[0]).add(values[i]);
			pairs.get(eq[1]).add(eq[0]);
			vals.get(eq[1]).add(1 / values[i]);
		}
		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			result[i] = dfs(query[0], query[1], pairs, vals, new HashSet<String>(), 1.0);
			if (result[i] == 0.0)
				result[i] = -1.0;
		}
		return result;
	}

	public double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> values,
			Set<String> visited, double value) {
		if (visited.contains(start))
			return 0.0;
		if (start.equals(end))
			return value;
		if (!pairs.containsKey(start))
			return 0.0;
		visited.add(start);
		List<String> strlist = pairs.get(start);
		List<Double> valList = values.get(start);
		double ans = 0;
		for (int i = 0; i < strlist.size(); i++) {
			ans = dfs(strlist.get(i), end, pairs, values, visited, value * valList.get(i));
			if (ans != 0.0)
				break;
		}
		visited.remove(start);
		return ans;
	}

	public static void main(String[] args) {

	}

}
