package com.leetcode;

import java.util.Arrays;

public class FindAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);
        for(int i = 0; i < indexes.length ; ++i){
            int ix = indexes[i];
            if(S.startsWith(sources[i], ix))
                match[ix] = i;
        }
        int ix = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(ix < N){
            if(match[ix] >= 0){
                stringBuilder.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            }
            else {
                stringBuilder.append(stringBuilder.charAt(ix++));
            }
        }
        return stringBuilder.toString();
    }
}
