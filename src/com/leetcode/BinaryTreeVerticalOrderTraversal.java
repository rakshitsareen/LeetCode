package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (root == null)
			return output;
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> idx = new LinkedList<Integer>();
		q.offer(root);
		idx.offer(0);
		List<Integer> rootList = new ArrayList<Integer>();
		rootList.add(root.val);
		map.put(0, rootList);
		int min = 0;
		int max = 0;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int id = idx.poll();
			if (node.left != null) {
				q.offer(node.left);
				idx.offer(id - 1);
				if (!map.containsKey(id - 1))
					map.put(id - 1, new LinkedList<Integer>());
				map.get(id - 1).add(node.left.val);
				min = Math.min(min, id - 1);
			}
			if (node.right != null) {
				q.offer(node.right);
				idx.offer(id + 1);
				if (!map.containsKey(id + 1))
					map.put(id + 1, new LinkedList<Integer>());
				map.get(id + 1).add(node.right.val);
				max = Math.max(max, id + 1);
			}
		}
		// now map is populated
		for (int i = min; i <= max; ++i) {
			output.add(map.get(i));
		}
		return output;
	}

}
