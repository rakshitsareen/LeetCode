package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberThree {

	public int rob(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		return robSub(root, map);
	}

	private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null)
			return 0;
		if (map.containsKey(root))
			return map.get(root);

		int val = 0;

		if (root.left != null) {
			val += robSub(root.left.left, map) + robSub(root.left.right, map);
		}

		if (root.right != null) {
			val += robSub(root.right.left, map) + robSub(root.right.right, map);
		}

		val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
		map.put(root, val);

		return val;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.insertLeft(new TreeNode(2)).insertRight(new TreeNode(3));
		root.insertRight(new TreeNode(3)).insertRight(new TreeNode(1));
		HouseRobberThree tree = new HouseRobberThree();
		System.out.println(tree.rob(root));
	}
}
