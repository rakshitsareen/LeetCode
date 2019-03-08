package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.
 */

public class FindAllAnagramsinString {
	
	 public List<Integer> findAnagramsSlidingWindow(String s, String p) {
		 List<Integer> output = new ArrayList<>();
	     if(s == null || s.length() == 0) return output;
	     if(p == null || p.length() == 0) return output;
	     int begin = 0, end = 0;
	     Map<Character, Integer> map = new HashMap<>();
	     for(Character c : p.toCharArray())
	        	map.put(c, map.getOrDefault(c, 0) + 1);
	     int counter = map.size();
	     while(end < s.length()) {
	    	 if(map.containsKey(s.charAt(end))) {
	    		 map.put(s.charAt(end), map.get(s.charAt(end)) - 1 );
	    		 if(map.get(s.charAt(end)) == 0) counter--;
	    	 } end++;
	    	 while(counter == 0) {
	    		 if(map.containsKey(s.charAt(begin))) {
	    			 map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
	    			 if(map.get(s.charAt(begin)) > 0) counter++;
	    		 }
	    		 if(end - begin == p.length()) output.add(begin);
	    		 begin++;
	    	 }
	     }
	     return output;
	 }
	
    public List<Integer> findAnagrams(String s, String p) {
    	// Runtime of this solution is high, but accepted on Leetcode
        List<Integer> output = new ArrayList<>();
        if(s == null || s.length() == 0) return output;
        if(p == null || p.length() == 0) return output;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> localmap = null;
        for(Character c : p.toCharArray())
        	map.put(c, map.getOrDefault(c, 0) + 1);
        for(int i = 0; i < s.length() - p.length() + 1; i++) {
        	localmap = new HashMap<>();
        	for(int j = 0; j < p.length(); j++)
        		localmap.put(s.charAt(i + j), localmap.getOrDefault(s.charAt(i + j), 0) + 1);
        	if(map.equals(localmap))
        		output.add(i);
        }
        return output;
    }

	public static void main(String[] args) {
		System.out.println(new FindAllAnagramsinString().findAnagramsSlidingWindow("cbaebabacd", "abc"));
		System.out.println(new FindAllAnagramsinString().findAnagramsSlidingWindow("abab", "ab"));
		System.out.println(new FindAllAnagramsinString().findAnagrams("cbaebabacd", "abc"));
		System.out.println(new FindAllAnagramsinString().findAnagrams("abab", "ab"));
	}

}
