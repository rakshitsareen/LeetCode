package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> output = new ArrayList<TreeNode>();
		Map<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
		helper(root, map);
		for (List<TreeNode> dups : map.values()) {
			if (dups.size() > 1)
				output.add(dups.get(0));
		}
		return output;
	}

	private String helper(TreeNode node, Map<String, List<TreeNode>> map) {
		if (node == null)
			return "";
		String key = "(" + helper(node.left, map) + node.val + helper(node.right, map) + ")";
		if (!map.containsKey(key))
			map.put(key, new ArrayList<TreeNode>());
		map.get(key).add(node);
		return key;
	}

}
