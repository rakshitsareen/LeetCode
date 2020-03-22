package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKinBinaryTree {

	Map<TreeNode, Integer> map = new HashMap<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		find(root, target);
		List<Integer> res = new ArrayList<>();
		dfs(root, target.val, res, K, map.get(root));
		return res;
	}

	private int find(TreeNode root, TreeNode target) {
		if (root == null)
			return -1;
		if (root.val == target.val) {
			map.put(root, 0);
			return 0;
		}
		int left = find(root.left, target);
		if (left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		int right = find(root.right, target);
		if (right >= 0) {
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}

	private void dfs(TreeNode root, int target, List<Integer> res, int K, int length) {
		if (root == null)
			return;
		if (map.containsKey(root))
			length = map.get(root);
		if (length == K)
			res.add(root.val);
		dfs(root.left, target, res, K, length + 1);
		dfs(root.right, target, res, K, length + 1);
	}
}
