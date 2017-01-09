package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllBST {
	public List<TreeNode> generateTrees(int n) {
		if(n==0){
	        return new ArrayList<TreeNode>();
	    }
		return generateTreesUtil(1, n);
	}

	private List<TreeNode> generateTreesUtil(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			// generate left trees
			List<TreeNode> leftTree = generateTreesUtil(start, i - 1);
			// generate right trees
			List<TreeNode> rightTree = generateTreesUtil(i + 1, end);
			// both right and left trees are constructed by now.
			// attach the trees now. simply joining every node to each other.
			for (int j = 0; j < leftTree.size(); j++) {
				TreeNode leftNode = leftTree.get(j);
				for (int k = 0; k < rightTree.size(); k++) {
					TreeNode rightNode = rightTree.get(k);
					TreeNode node = new TreeNode(i);
					node.left = leftNode;
					node.right = rightNode;
					list.add(node);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		AllBST allbst = new AllBST();
		List<TreeNode> list = allbst.generateTrees(2);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).val);
	}
}
