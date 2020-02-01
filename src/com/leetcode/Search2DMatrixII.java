package com.leetcode;

public class Search2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;
		int row = 0;
		int col = matrix[0].length - 1;
		while(col >= 0 && row <= matrix.length -1) {
			if(matrix[row][col] == target) return true;
			else if(target < matrix[row][col]) col--;
			else row++;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
