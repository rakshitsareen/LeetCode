package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {

	private final List<List<Integer>> globalList = new LinkedList<>();
	Integer[] pathTillNow = new Integer[100];	// assuming there is no leg greater than 100 elements.
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null) return new LinkedList<List<Integer>>();	// no path.
		//if(root.left == null && root.right == null) {List<List<Integer>> list = new LinkedList<>(); list.add( ((new List<Integer>).add(root.val)) ); return list;}
		return pathSumUtil(root, pathTillNow, 0, sum);
	}
	
	private List<List<Integer>> pathSumUtil(TreeNode root, Integer[] pathTillNow, int level, int sum){
		if(root == null) return new LinkedList<>();
		pathTillNow[level++] = root.val;
		sum-=root.val;
		if(sum == 0 && root.left == null && root.right == null){ populateGlobalList(pathTillNow,level); return globalList;}	// if a leaf node, convert path to a list and consumes sum.
		if(root.left!=null) pathSumUtil(root.left, pathTillNow, level,sum);
		if(root.right!=null) pathSumUtil(root.right, pathTillNow, level,sum);
		return globalList;
	}
	
	private void populateGlobalList(Integer[] path,int length){
		List<Integer> bld = new LinkedList<>();
		int i = length;
		for(Integer str : path){
			if(i<=0) break;
			bld.add(str);
			i--;
		}
		globalList.add(bld);
	}

	public static void main(String[] args) {
		/*
		      5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
		 
		*/
		
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.right.right.left = new TreeNode(5);
		PathSum2 sol = new PathSum2();
		System.out.println(sol.pathSum(root,22));
	}
}



/* LeetCode Top Solution
 * 
public List<List<Integer>> pathSum(TreeNode root, int sum){
	List<List<Integer>> result  = new LinkedList<List<Integer>>();
	List<Integer> currentResult  = new LinkedList<Integer>();
	pathSum(root,sum,currentResult,result);
	return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
		List<List<Integer>> result) {

	if (root == null)
		return;
	currentResult.add(new Integer(root.val));
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(currentResult));
		currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
		return;
	} else {
		pathSum(root.left, sum - root.val, currentResult, result);
		pathSum(root.right, sum - root.val, currentResult, result);
	}
	currentResult.remove(currentResult.size() - 1);
}

*/
