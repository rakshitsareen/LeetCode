package com.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths {

	public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null)
			return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) { // level not contained in the list
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	public ArrayList<LinkedList<TreeNode>> makeListOfDepths(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.right.left.right = new TreeNode(8);
	    root.right.right.right = new TreeNode(9);
	    
	    ListOfDepths sol = new ListOfDepths();
	    ArrayList<LinkedList<TreeNode>> ans = sol.makeListOfDepths(root);
	    for(LinkedList<TreeNode> l : ans){
	    	while(!l.isEmpty()){
	    		System.out.println(l.getFirst().value);
	    		l.removeFirst();
	    	}
	    	System.out.println();
	    }
	    //System.out.println(ans);
	}

}
