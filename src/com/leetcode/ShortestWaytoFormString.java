package com.leetcode;

public class ShortestWaytoFormString {
    public int shortestWay(String source, String target) {
        char[] s  = source.toCharArray(), t = target.toCharArray();
        int i = 0, j = 0, res = 0;
        while(i < t.length && res <= i){
            while(j < s.length && t[i] != s[j]) j++;
            if(j == s.length){j = 0; res++;}
            else {++i; ++j;}
        }
        return res <= i? res+1: -1;
    }
}
