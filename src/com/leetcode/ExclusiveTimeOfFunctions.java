package com.leetcode;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int pre = 0;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        for(String log : logs){
            String[] val = log.split(":");
            int curr = Integer.parseInt(val[2]);
            int id = Integer.parseInt(val[0]);
            String status = val[1];
            if(status.equals("start")){
                if(!stack.isEmpty()) result[stack.peek()] += curr - pre;
                stack.push(id);
                pre = curr;
            }
            else {
                result[stack.pop()] +=curr - pre + 1;
                pre = curr + 1;
            }
        }
        return result;
    }
}
