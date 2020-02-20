package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	
    public boolean isAnagram(String s, String t) {
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
    	for(char c : s.toCharArray()) {
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	
    	for(char c : t.toCharArray()) {
    		if(!map.containsKey(c)) return false;
    		map.put(c, map.get(c) - 1);
    	}
    	for(Map.Entry<Character, Integer> entry : map.entrySet())
    		if(entry.getValue() > 0) return false;
        return true;
    }

}
