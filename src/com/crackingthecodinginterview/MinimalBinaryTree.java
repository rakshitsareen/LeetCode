package com.crackingthecodinginterview;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int val) {
		value = val;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
}

class Tree {
	TreeNode root;
}

public class MinimalBinaryTree {

	// node fun(array,m,n)
	// if array.size == 1;
	// return new Node(array[0]);
	// mid = m + (n-m+1)/2;
	// root.value = array[mid];
	// root->left = fun(0,mid-1);
	// root->right = fun(mid+1,n);

	public TreeNode createMinimal(int[] array, int m, int n) {
		if (m == n)
			return new TreeNode(array[m]);
		if (n < m)
			return null;

		int mid = (m + n) / 2;

		TreeNode root = new TreeNode(array[mid]);
		root.left = createMinimal(array, m, mid - 1);
		root.right = createMinimal(array, mid + 1, n);
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.value);
		inorder(root.right);
	}

	public static void main(String[] args) {
		int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		MinimalBinaryTree sol = new MinimalBinaryTree();
		TreeNode root = sol.createMinimal(sortedArray, 0, sortedArray.length - 1);
		sol.inorder(root);
		return;
	}
}
