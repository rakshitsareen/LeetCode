package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		path.add(0);
		dfs(graph, 0, res, path);
		return res;
	}
	private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
		if(node == graph.length - 1) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		for(int n : graph[node]) {
			path.add(n);
			dfs(graph, n, res, path);
			path.remove(path.size() - 1);
		}
	}

}
