package com.leetcode;

public class KthSmallestElementInBST {

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (count >= k) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1)
			return kthSmallest(root.right, k - count - 1);
		return root.val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
