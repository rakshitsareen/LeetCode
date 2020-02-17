package com.leetcode;

public class ReverseWordsInAStringIII {
	
    public static String reverseWords(String s) {
    	StringBuilder res = new StringBuilder();
    	if(s == null) return res.toString();
    	String[] str = s.split(" ");
    	for(int i = 0; i < str.length; ++i) str[i] = new StringBuilder(str[i]).reverse().toString();
    	for(String _s : str) res.append(_s + " ");
    	return res.toString().trim();
    }
    
    public static void main(String[] args) {
    	System.out.println(reverseWords("Let's take LeetCode contest"));
    }

}
