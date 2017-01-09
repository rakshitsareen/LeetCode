package com.leetcode;
//TODO: Wrong solution, use stacks instead.
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

	public boolean leftToRightInsertion = false;

		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	
			if (root == null) {
				List<List<Integer>> list = new LinkedList<>();
				return list;
			}
	
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			List<List<Integer>> list = new LinkedList<>();
			queue.add(root);
			queue.add(null); // marks the start of a new level
			List<Integer> levelList = new LinkedList<>();
			boolean finishedAllLevels = false;
			while (!queue.isEmpty()) {
				if (queue.peek() == null) { // reached the end of level
					queue.poll(); // remove the null marker
					leftToRightInsertion = !leftToRightInsertion;
					list.add(levelList);
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
					// System.out.print(node.val + " ");
					levelList.add(node.val);
					// list.add(node.val);
					if (leftToRightInsertion) {
						if (node.left != null) {
							queue.add(node.left);
						}
						if (node.right != null) {
							queue.add(node.right);
						}
					} else {
						if (node.right != null) {
							queue.add(node.right);
						}
						if (node.left != null) {
							queue.add(node.left);
						}
					}
				}
			}
			return list;
	
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		ZigZagTraversal traversal = new ZigZagTraversal();
		System.out.println(traversal.zigzagLevelOrder(root));
	}
}
