package com.leetcode;

/*
 * Approach
Step 1: Find maximum area for row[0]
Step 2:
    for each row in 1 to N - 1
        for each column in that row
            if A[row][column] == 1
              update A[row][column] with
                A[row][column] += A[row - 1][column]
    find area for that row
    and update maximum area so far 

 */
public class MaximumRectangleMatrixWithAllOnes {

	public int largestRectangle(int[][] arr) {
		
		return -1;
	}

	public static void main(String[] args) {

	}

}
