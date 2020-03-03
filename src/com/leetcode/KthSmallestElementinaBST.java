package com.leetcode;

public class KthSmallestElementinaBST {
	int save = 0;
	int ans = 0;

	public int kthSmallest(TreeNode root, int k) {
		save = k;
		helper(root);
		return ans;
	}

	private void helper(TreeNode root) {

		if (root.left != null) {
			helper(root.left);
		}

		save--;
		if (save == 0) {
			ans = root.val;
			return;
		}

		if (root.right != null)
			helper(root.right);
	}

}
