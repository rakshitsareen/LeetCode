package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int aptr = 0;
            int bptr = 0;
            List<int[]> output = new LinkedList<>();
            while(aptr < A.length && bptr < B.length){
                int astart = A[aptr][0], aend = A[aptr][1];
                int bstart = B[bptr][0], bend = B[bptr][1];
                int cstart = Math.max(astart, bstart);
                int cend = Math.min(aend,bend);
                if(cstart <= cend)
                    output.add(new int[]{cstart, cend});
                if(bend < aend) bptr++;
                else if(aend < bend) aptr++;
                else {aptr++;bptr++;}
            }
            return output.toArray(new int[output.size()][]);
        }

        public static void main(String[] args){
            IntervalListIntersections sol = new IntervalListIntersections();
            int[][] A = {{0,2},{5,10},{13,23},{24,25}};
            int[][] B = {{1,5},{8,12},{15,24},{25,26}};
            int[][] C = sol.intervalIntersection(A,B);
            for(int[] ans : C){
                System.out.println(ans[0] + " : " + ans[1]);
            }
        }
    }
