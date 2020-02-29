package com.crackingthecodinginterview;

public class RecoverBST {
	private TreeNode prev, first, middle, last;
	TreeNode _first = null;
	TreeNode _second = null;
	TreeNode _prev = new TreeNode(Integer.MIN_VALUE);

	public void correctBSTUtil(TreeNode root) {
		if (root == null)
			return;
		correctBSTUtil(root.left);
		if (prev != null && root.value < prev.value)
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		prev = root;
		correctBSTUtil(root.right);
	}

	public void correctBST(TreeNode root) {
		correctBSTUtil(root);
		if (first != null && last != null) {
			int temp = last.value;
			last.value = first.value;
			first.value = temp;
		} else if (middle != null && first != null) {
			int temp = first.value;
			first.value = middle.value;
			middle.value = temp;
		}
		return;
	}

	void printInorder(TreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(" " + node.value);
		printInorder(node.right);
	}

	public void recoverTree(TreeNode root) {
		traverse(root);
		int temp = _first.value;
		_first.value = _second.value;
		_second.value = temp;
	}

	private void traverse(TreeNode root) {
		if (root == null)
			return;
		traverse(root.left);
		if (_first == null && _prev.value > root.value) {
			_first = prev;
		}
		if (_first != null && _prev.value > root.value)
			_second = root;
		_prev = root;
		traverse(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(10);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(12);
		root.right.left = new TreeNode(7);

		RecoverBST sol = new RecoverBST();
		sol.printInorder(root);
		sol.correctBST(root);
		System.out.println("");
		sol.printInorder(root);
	}

}
