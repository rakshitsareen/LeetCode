package com.leetcode;

public class DeleteNodeinaBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (root.left == null && root.right == null && root.val == key)
			return null;
		if (root.left == null && root.right == null && root.val != key)
			return root;
		if (root.val < key)
			root.right = deleteNode(root.right, key);
		else if (root.val > key)
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			TreeNode minNode = findmin(root.right);
			root.val = minNode.val;
			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	private TreeNode findmin(TreeNode node) {
		while (node.left != null)
			node = node.left;
		return node;
	}
}
