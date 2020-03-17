package com.leetcode;

public class Search2DMatrixI {

	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
		int l = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int r = n * m - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
            if (matrix[mid / m][mid % m] == target) {
                    return true;
                }
			if (matrix[mid / m][mid % m] < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return false;
	
    }
}
