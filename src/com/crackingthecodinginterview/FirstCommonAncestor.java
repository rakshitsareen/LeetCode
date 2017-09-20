package com.crackingthecodinginterview;

public class FirstCommonAncestor {

	private TreeNode and;

	public void firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		boolean bool = firstCommonAncestorUtil(root, a, b, and);
		if (and != null) {
			System.out.println(and);
		}
	}

	public boolean firstCommonAncestorUtil(TreeNode root, TreeNode a, TreeNode b, TreeNode ans) {
		if (root == null) {
			return false;
		}

		boolean left = firstCommonAncestorUtil(root.left, a, b, ans);
		boolean right = firstCommonAncestorUtil(root.right, a, b, ans);

		if (left && right) {
			and = root;
			System.out.println("found it first");
			return true;
		}

		if ((left || right) && (root == a || root == b)) {
			and = root;
			System.out.println("found it me too");
			return true;
		}

		if ((left && right) || (root == a || root == b))
			return true;

		if ((root != a && root != b) && left && right)
			return false;

		if ((root != a && root != b) && (left || right))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		FirstCommonAncestor sol = new FirstCommonAncestor();
		sol.firstCommonAncestor(tree.root, tree.root.left.left, tree.root.right.right);

	}

}
