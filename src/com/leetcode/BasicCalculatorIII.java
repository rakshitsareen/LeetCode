package com.leetcode;

public class BasicCalculatorIII {
    public int calculate(String s) {
        int l1 = 0, l2 = 1, o1 = 1, o2 = 1;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }
                l2 = (o2 == 1 ? l2 * num : l2 / num);
            }
            else if (c == '('){
                int j = i;
                for(int cnt = 0; i < s.length(); ++i){
                    if(s.charAt(i) == '(') cnt++;
                    if(s.charAt(i) == ')') cnt--;
                    if(cnt == 0) break;
                }
                int num = calculate(s.substring(j + 1, i));
                l2 = (o2 == 1 ? l2 * num : l2 / num);
            }
            else if(c == '*' || c== '/'){
                o2 = (c == '*' ? 1 : -1);
            }
            else if(c == '+' || c == '-'){
                l1 = l1 + o1 * l2;
                o1 = (c == '+' ? 1 : -1);
                l2 = 1; o2 = 1;
            }
        }
        return l1 + o1 * l2;
    }

    public static void main(String[] args){
        String s = "2*(5+5*2)/3+(6/2+8)";
        BasicCalculatorIII calc = new BasicCalculatorIII();
        System.out.println(calc.calculate(s));
    }
}


/*
common framework for calculator problems
Reference: https://leetcode.com/problems/basic-calculator-iii/discuss/113592/Development-of-a-generic-solution-for-the-series-of-the-calculator-problems

public int calculate(String s) {
    int l1 = 0, o1 = 1; // Initialization of level one
    int l2 = 1, o2 = 1; // Initialization of level two

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c is a digit) {

           --> we have an operand of type number, so find its value "num"
           --> then evaluate at level two: l2 = (o2 == 1 ? l2 * num : l2 / num);

        } else if (c is a lowercase letter) {

           --> we have an operand of type variable, so find its name "var"
           --> then look up the variable mapping table to find its value "num";
           --> lastly evaluate at level two: l2 = (o2 == 1 ? l2 * num : l2 / num);

        } else if (c is an opening parenthesis) {

           --> we have an operand of type subexpression, so find its string representation
           --> then recursively call the "calculate" function to find its value "num";
           --> lastly evaluate at level two: l2 = (o2 == 1 ? l2 * num : l2 / num);

        } else if (c is a level two operator) {

            --> o2 needs to be updated: o2 = (c == '*' ? 1 : -1);

        } else if (c is a level one operator) {

            --> demotion happens here: l1 = l1 + o1 * l2;
            --> o1 needs to be updated: o1 = (c == '+' ? 1 : -1);
            --> l2, o2 need to be reset: l2 = 1, o2 = 1;

       }

       return (l1 + o1 * l2); // end of expression reached, so demotion happens again
}

 */