package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNums {
	List<Integer> digitList = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
    	int[] path = new int[100];
    	if(root == null) return 0;
    	return sumNumbersUtil(root, path, 0);
    }
    
    private int sumNumbersUtil(TreeNode root, int[] path, int level){
    	path[level++] = root.val;
    	if(isLeaf(root)) { makeDigit(path,level);}
    	if(root.left != null) sumNumbersUtil(root.left, path, level+1);
    	if(root.right != null) sumNumbersUtil(root.right, path, level+1);
    	return sumNumbersInGlobalList();
    }
    
    private int sumNumbersInGlobalList(){
    	//assumes digitList contains integers only.
    	
    	if(digitList != null && digitList.size() > 0){
    		Integer sum = 0;
    		for(int in : digitList){
    			sum+=in;
    		}
    		return sum;
    	}
    	else 
    		return 0;
    }
    
    private void makeDigit(int[] path, int level){
    	// make digit out of path and insert in digitList.
    	int i = 0;
    	while(level-- >= 0){
    		
    	}
    }
    
    private boolean isLeaf(TreeNode node){
    	return (node.left == null && node.right == null);
    }
	
	public static void main(String[] args){
		
	}
}
