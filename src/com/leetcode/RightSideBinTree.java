package com.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideBinTree {
	public List<Integer> rightSideOfBinaryTree(TreeNode root) {

		if (null == root) {
			List<Integer> emptyList = new LinkedList<>();
			return emptyList;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null); // marks the start of a new level
		List<Integer> levelList = new LinkedList<>();
		List<Integer> rightViewList = new LinkedList<>();
		boolean finishedAllLevels = false;
		Integer savePrevious = null;
		while (!queue.isEmpty()) {
			if (queue.peek() == null) { // reached the end of level
				queue.poll(); // remove the null marker
				rightViewList.add(savePrevious);
				levelList = new LinkedList<>();
				if (queue.size() > 0) { // if there are more levels to be
										// processed.
					queue.add(null); // previous level ended. Thus, start a new
										// level.
				} else
					finishedAllLevels = true;
			}
			if (!finishedAllLevels) {
				TreeNode node = queue.poll();
				savePrevious = node.val;
				// System.out.print(node.val + " ");
				levelList.add(node.val);
				// list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return rightViewList;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		RightSideBinTree rvtree = new RightSideBinTree();
		System.out.println(rvtree.rightSideOfBinaryTree(root));
	}
}
