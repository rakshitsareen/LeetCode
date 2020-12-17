package com.leetcode;

public class DistanceOfNodes {

	private TreeNode and;

	public TreeNode firstCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		firstCommonAncestorUtil(root, a, b, and);
		if (and != null) {
			return and;
		}
		return null;
	}

	public boolean firstCommonAncestorUtil(TreeNode root, TreeNode a, TreeNode b, TreeNode ans) {
		if (root == null) {
			return false;
		}

		boolean left = firstCommonAncestorUtil(root.left, a, b, ans);
		boolean right = firstCommonAncestorUtil(root.right, a, b, ans);

		if (left && right) {
			and = root;
			// System.out.println("found it first");
			return true;
		}

		if ((left || right) && (root == a || root == b)) {
			and = root;
			// System.out.println("found it me too");
			return true;
		}

		if (root == a || root == b)
			return true;

        return (root != a && root != b) && (left || right);
    }

	public int findLevel(TreeNode root, TreeNode node, int level) {
		if (root == null)
			return -1;
		if (root == node)
			return level;
		int left = findLevel(root.left, node, level + 1);
		if (left == -1)
			return findLevel(root.right, node, level + 1);
		return left;
	}

	public int findDistanceBetweenTwoNodes(TreeNode root, TreeNode left, TreeNode right) {
		TreeNode lca = firstCommonAncestor(root, left, right);
		if (lca == null)
			lca = root;
		return findLevel(lca, left, 0) + findLevel(lca, right, 0);
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
		DistanceOfNodes sol = new DistanceOfNodes();
		int ans = sol.findDistanceBetweenTwoNodes(tree.root, tree.root.left.left, tree.root);
		System.out.println(ans);
	}

}
