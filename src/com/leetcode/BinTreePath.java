package com.leetcode;
import java.util.LinkedList;
import java.util.List;
public class BinTreePath {

	private List<String> globalList = new LinkedList<>();
	String[] pathTillNow = new String[100];	// assuming there is no leg greater than 100 elements.
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return new LinkedList<String>();	// no node.
		if(root.left == null && root.right == null) {List<String> list = new LinkedList<>(); list.add(root.val.toString()); return list;}
		return binaryTreePathsUtil(root, pathTillNow, 0);
	}
	
	private List<String> binaryTreePathsUtil(TreeNode root, String[] pathTillNow, int level){
		if(root == null) return new LinkedList<>();
		pathTillNow[level++] = root.val.toString();
		if(root.left == null && root.right == null){ populateGlobalList(pathTillNow,level); return globalList;}	// if a leaf node, convert path to a list.
		if(root.left!=null) binaryTreePathsUtil(root.left, pathTillNow, level);
		if(root.right!=null) binaryTreePathsUtil(root.right, pathTillNow, level);
		return globalList;
	}
	
	private void populateGlobalList(String[] path,int length){
		StringBuilder bld = new StringBuilder();
		int i = length;
		for(String str : path){
			if(i<=0) break;
			bld.append(str); if(i>1) bld.append("->");
			i--;
		}
		String returnString = new String(bld);
		globalList.add(returnString);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		BinTreePath sol = new BinTreePath();
		System.out.println(sol.binaryTreePaths(root));
	}
}
