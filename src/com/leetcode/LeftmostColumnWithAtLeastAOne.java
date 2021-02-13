package com.leetcode;


import java.util.List;

interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
}

public class LeftmostColumnWithAtLeastAOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        // binary search for each row
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int output = cols;
        for(int row = 0; row < rows; row++){
            // binary search this row now
            int lo = 0, hi = cols - 1;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(binaryMatrix.get(row, mid) == 0)
                    lo = mid + 1;
                else hi = mid;
            }
            if(binaryMatrix.get(row, lo) == 1){
                output = Math.min(output, lo);
            }
        }
        return output == cols ? -1 : output;
    }
}
