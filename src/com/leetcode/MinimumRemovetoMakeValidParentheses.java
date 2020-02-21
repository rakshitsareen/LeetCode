package com.leetcode;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {
	
    public static String minRemoveToMakeValid(String s) {
    	StringBuilder res = new StringBuilder(s);
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i = 0; i < s.length(); ++i) {
    		if(s.charAt(i) == '(') stack.push(i);
    		if(s.charAt(i) == ')') {
    			if(!stack.isEmpty()) stack.pop();
    			else res.setCharAt(i, '*');
    		}
    	}
    	while(!stack.isEmpty())
    		res.setCharAt(stack.pop(), '*');
    	return res.toString().replaceAll("\\*", "");
    }
    
    public static void main(String[] args) {
    	System.out.println(minRemoveToMakeValid("a)b(c)d"));
    }

}
