package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String key = getKey(s);
            map.computeIfAbsent(key, x->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    private String getKey(String s){
        String key = "";
        char[] chars = s.toCharArray();
        for(int i = 1; i < s.length(); ++i){
            int diff = chars[i] - chars[i-1];
            key += diff < 0 ? diff + 26 : diff;
            key += ",";
        }
        return key;
    }
}
