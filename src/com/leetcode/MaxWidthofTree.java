package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxWidthofTree {
	/*
	 * binary tree can be represented by an array (assume the root begins from the
	 * position with index 1 in the array). If the index of a node is i, the indices
	 * of its two children are 2*i and 2*i + 1. The idea is to use two arrays
	 * (start[] and end[]) to record the the indices of the leftmost node and
	 * rightmost node in each level, respectively. For each level of the tree, the
	 * width is end[level] - start[level] + 1. Then, we just need to find the
	 * maximum width.
	 */

	private static int widthUtil(TreeNode root, int level, int mypos, List<Integer> start, List<Integer> end) {
		if (root == null)
			return 0;
		if (start.size() == level) { // starting new level
			start.add(mypos);
			end.add(mypos);
		} else {
			end.set(level, mypos);
		}
		int maxAtThisLevel = end.get(level) - start.get(level) + 1; // max width at this level. subsequent calls will
																	// fill end list properly.
		int fromleft = widthUtil(root.left, level + 1, mypos * 2, start, end);
		int fromright = widthUtil(root.right, level + 1, mypos * 2 + 1, start, end);
		return Math.max(maxAtThisLevel, Math.max(fromleft, fromright));
	}

	public static int widthOfBinaryTree(TreeNode root) {
		List<Integer> start = new ArrayList<>();
		List<Integer> end = new ArrayList<>();
		return widthUtil(root, 0, 1, start, end);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(widthOfBinaryTree(root));
	}
}
