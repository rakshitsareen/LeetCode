package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> idx = new HashMap<>();
        int id = 0;
        for(char c : order.toCharArray()){
            idx.put(c, id++);
        }
        for(int i = 0; i < words.length - 1; ++i){
            String curr = words[i];
            String next = words[i + 1];
            boolean doBreak = false;
            int len = Math.min(curr.length(), next.length());
            int k = 0;
            while(k < len){
                while(k < len && curr.charAt(k) == next.charAt(k)) k++;
                if(k < len) {
                    if (idx.get(curr.charAt(k)) > idx.get(next.charAt(k))) return false;
                    else {doBreak = true; break;}
                }
                k++;
            }
            if(doBreak) continue;
            if(curr.length() > next.length()) return false;
        }
        return true;
    }
    public static void main(String[] args){
        String[] words = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        String order = "zkgwaverfimqxbnctdplsjyohu";
        System.out.println(VerifyingAlienDictionary.isAlienSorted(words, order));
    }
}

/*
["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"]
"zkgwaverfimqxbnctdplsjyohu"
 */