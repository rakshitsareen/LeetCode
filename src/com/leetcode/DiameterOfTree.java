package com.leetcode;

public class DiameterOfTree {
	
	int max = 0;

	public static int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static int diameter(TreeNode root) {
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);

		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		// return the maximum of left + right height, or any other if encountered 
		// from the subproblem
		return Math.max(rheight + lheight, Math.max(ldiameter, rdiameter));
	}
	
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right); 
        return Math.max(left,right) + 1;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(diameter(root));
	}

}
