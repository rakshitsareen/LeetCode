package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 				1
 * 			  /   \
 * 			 2	   3
 * 			/ \   / \
 * 		   4   5 6   7
 *	Order printed is [[4,5,6,7],[2,3],[1]]
 *
 */
public class LevelOrder2 {

/*	public void printLevelReverse(Stack<List<Integer>> levelStack) {
		if (levelStack != null) {
			while (!levelStack.isEmpty()) {
				List<Integer> levelList = levelStack.pop();
				Iterator<Integer> itr = levelList.iterator();
				while (itr.hasNext()) {
					System.out.println(itr.next().toString());
				}
			}
		}
	}*/
	
	void printLevelOrderFromList(List<List<Integer>> list) {
		List<Integer> levelList;
		if (null != list && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				// extract the i'th level list and print it.
				levelList = list.get(i);
				//k = 0;
				//iterator technique
				Iterator<Integer> itr = levelList.iterator();
				while(itr.hasNext()){
					System.out.println(itr.next());
				}
				
			/*	while (!levelList.isEmpty()) {
					System.out.print(levelList.get(k) + " ");
					k++;
					System.out.println("\n");
				}*/
			}
		}
	}

	public static void main(String[] args) {
		LevelOrder2 levelOrder = new LevelOrder2();
		TreeNode root = new TreeNode(1);
		root.insertLeft(new TreeNode(2)).insertLeft(new TreeNode(4)).insertRight(new TreeNode(5));
		root.insertRight(new TreeNode(3)).insertLeft(new TreeNode(6)).insertRight(new TreeNode(7));
		List<List<Integer>> levelList = levelOrder.levelOrder(root);
		levelOrder.printLevelOrderFromList(levelList);
		//levelOrder.printLevelReverse(levelStack);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		Stack<List<Integer>> levelStack = new Stack<>();
		if (null == root) {
			return new LinkedList<>();
			// return emptyList;
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
				list.add(levelList);
				// add to the bottom of the Stack
				levelStack.push(levelList);
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
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return convertStackOfListToListOfList(levelStack);
	}
	
	public List<List<Integer>> convertStackOfListToListOfList(Stack<List<Integer>> levelStack){
		List<List<Integer>> levelList = new LinkedList<>();
		while(!levelStack.isEmpty()){
			levelList.add(levelStack.pop());
		}
		return levelList;
	}
}
