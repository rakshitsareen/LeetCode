package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int output = 0;
        if(k <= 0) return k;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, num = 0;
        for(int r = 0; r < s.length(); ++r){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size() > k){
                char c = s.charAt(l);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                }
                l++;
            }
            output = Math.max(output, r-l+1);
        }
        return output;
    }
}
