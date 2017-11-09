package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

	private static int levels(TreeNode root) {
		if (root == null)
			return 0;
		else
			return Math.max(levels(root.left), levels(root.right)) + 1;
	}

	static void printUtil(TreeNode root, List<List<String>> list, int level, int len, int start, int end) {
		if (root == null)
			return;
		if (list.size() == level) { // we have not visited this level at all
			list.add(level, new ArrayList<String>(len));
			for (int i = 0; i < len; i++)
				list.get(level).add(" ");
		}
		list.get(level).set((end + start) / 2, Integer.toString(root.val));
		if (root.left != null)
			printUtil(root.left, list, level + 1, len, start, (end + start) / 2 - 1);
		if (root.right != null)
			printUtil(root.right, list, level + 1, len, (end + start) / 2 + 1, end);
	}

	public static List<List<String>> printBinaryTree(TreeNode root) {
		int levels = levels(root);
		int len = (int) Math.pow(2, levels) - 1;
		List<List<String>> ans = new ArrayList<>();
		printUtil(root, ans, 0, len, 0, len - 1);
		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		// System.out.println(levels(root));
		List<List<String>> ans = printBinaryTree(root);
		for (List<String> l : ans)
			for (String s : l) {
				System.out.print(s);
			}
		System.out.println();
	}

}
