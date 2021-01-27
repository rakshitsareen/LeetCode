package com.leetcode;


import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int operation = '+';
        int n = s.length();
        int current = 0;
        for (int i = 0; i <n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                current = (current * 10) + (c - '0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1){
                if(operation == '+'){
                    stack.push(current);
                }
                if(operation == '-')
                    stack.push(-current);
                if(operation == '*')
                    stack.push(stack.pop() * current);
                if (operation == '/')
                    stack.push(stack.pop()/current);
                current = 0;
                operation = c;
            }
        }
        int output = 0;
        while(!stack.isEmpty()){
            output += stack.pop();
        }
        return output;
    }

    public static void main(String[] args){
        String s = "3+5 / 2 ";
        BasicCalculatorII calculatorII = new BasicCalculatorII();
        System.out.println(calculatorII.calculate(s));
    }
}
