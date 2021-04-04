package com.leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] p = new int[m + n];
        for(int i = n - 1; i >= 0 ; --i){
            for(int j = m - 1; j >= 0; --j){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + p[p2];
                p[p1] += sum / 10;
                p[p2] = sum % 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int x : p) if(!(stringBuilder.length() == 0 && x == 0)) stringBuilder.append(x);
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args){
        String a = "123", b = "456";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply(a, b));
    }
}
