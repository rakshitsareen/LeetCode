package com.leetcode;

import java.io.CharArrayReader;
import java.util.*;

public class AlienDictionary {
    /*
    There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
    You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of
    this new language.
    Derive the order of letters in this language, and return it. If the given input is invalid, return "".
    If there are multiple valid solutions, return any of them.

    Input: words = ["wrt","wrf","er","ett","rftt"]
    Output: "wertf"

     */

    public String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<>();
        StringBuilder result = new StringBuilder();
        if(words == null || words.length == 0) return result.toString();
        for(String s : words){
            for(char c : s.toCharArray()){
                degree.put(c, 0);
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for(int i = 0; i < words.length - 1; ++i){
            String curr = words[i];
            String next = words[i + 1];
            if(curr.length() > next.length() && curr.startsWith(next)) return "";
            int length = Math.min(curr.length(), next.length());
            for (int j = 0; j <length; j++) {
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    if (!map.containsKey(c1)) {
                        map.put(c1, new HashSet<>());
                    }
                    if(!map.get(c1).contains(c2)){
                        map.get(c1).add(c2);
                        degree.put(c2, degree.getOrDefault(c2, 0) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(char c : degree.keySet()){
            if(degree.get(c) == 0)
                queue.offer(c);
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            if(map.containsKey(c))
                for(char after : map.get(c)){
                degree.put(after, degree.get(after) - 1);
                if(degree.get(after) == 0) queue.offer(after);
                }
        }
        if(result.toString().length() != degree.size()) return "";
        return result.toString();
    }
}
