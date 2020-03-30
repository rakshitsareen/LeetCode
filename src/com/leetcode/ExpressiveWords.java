package com.leetcode;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int output = 0; 
        for(String w : words)
            if(check(S, w)) output++;
        return output;
    }
    
    private boolean check(String S, String W){
        int i = 0, j = 0;
        int n = S.length(), m = W.length();
        for(int i2 = 0, j2 = 0; i < n && j < m; i = i2, j = j2){
            if(S.charAt(i) != W.charAt(j)) return false;
            while(i2 < n && S.charAt(i) == S.charAt(i2)) i2++;
            while(j2 < m && W.charAt(j) == W.charAt(j2)) j2++;
            if(i2-i != j2-j && i2-i < Math.max(3, j2-j)) return false;
        }
        return i == n && j == m;
    }
}
