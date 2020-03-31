package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> set = new HashSet<Integer>(Arrays.stream(to_delete).boxed().collect(Collectors.toList()));
		List<TreeNode> res = new ArrayList<TreeNode>();
		helper(root, null, set, res);
		return res;
	}

	private void helper(TreeNode root, TreeNode parent, Set<Integer> to_delete, List<TreeNode> res) {
		if (root == null)
			return;
		helper(root.left, root, to_delete, res);
		helper(root.right, root, to_delete, res);
		if (to_delete.contains(root.val)) {
			if (null != root.left) {
				res.add(root.left);
				root.left = null;
			}
			if (null != root.right) {
				res.add(root.right);
				root.right = null;
			}
			if (parent != null) {
				if (parent.left == root)
					parent.left = null;
				else
					parent.right = null;
			} else {
				if (root.left != null) {
					res.add(root.left);
					root.left = null;
				}
				if (root.right != null) {
					res.add(root.right);
					root.right = null;
				}
			}
		} else if (parent == null) {
			res.add(root);
		}
	}

}
