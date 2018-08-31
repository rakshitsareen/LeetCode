package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST {
	Set<Integer> set = new HashSet<>();

	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;
		if (k == 0)
			return true;
		if (set.contains(k - root.val))
			return true;
		else
			set.add(root.val);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}

	public static void main(String[] args) {

	}

}
