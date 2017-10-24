package com.crackingthecodinginterview;

public class RecoverBST {
	private TreeNode prev, first, middle, last;

	public void correctBSTUtil(TreeNode root) {
		if (root == null)
			return;
		correctBST(root.left);
		if (prev != null && root.value < prev.value)
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		prev = root;
		correctBST(root.right);
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
