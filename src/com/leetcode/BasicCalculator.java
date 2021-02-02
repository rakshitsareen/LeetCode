package com.leetcode;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int current = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                current = current * 10 + (int)(c - '0');
            }
            if(!Character.isDigit(c) && !Character.isWhitespace(c)){
                if(c == '+'){
                    result += sign * current;
                    current = 0;
                    sign = 1;
                }
                else if(c == '-'){
                    result += sign * current;
                    current = 0;
                    sign = -1;
                }
                else if(c == '('){
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                }
                else if(c == ')'){
                    result += sign * current;
                    current = 0;
                    result *= stack.pop();
                    result += stack.pop();
                }
            }
        }
        if(current != 0) result += sign * current;
        return result;
    }
    public static void main(String[] args){
//        String s = "(1+(4+5+2)-3)+(6+8)";
        String s = " 2-1 + 2 ";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(s));
    }
}
