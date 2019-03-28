package com.leetcode;

public class SymmetricTree {
	
    public boolean isSymmetric(TreeNode root) {
    	if(null == root) return true;
    	return isSymmetricUtil(root.left, root.right);
    }
    
    public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
    	if(left == null || right == null)
    		return left == right;
    	if(left.val != right.val) return false;
    	return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
