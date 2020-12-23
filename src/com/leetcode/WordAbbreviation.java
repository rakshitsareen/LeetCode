package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordAbbreviation {
    public List<String> wordsAbbreviation(List<String> dict) {
        int len = dict.size();
        int[] prefix = new int[len];
        String[] ans = new String[len];
        for(int i = 0; i < len; i++){
            prefix[i] = 1;
            ans[i] = makeAbbr(dict.get(i), 1);
        }
        for (int i=0;i<len;i++)
            while(true){
                Set<Integer> set = new HashSet<>();
                for(int j = i+1; j < len; ++j){
                    if(ans[i].equals(ans[j])) set.add(j);
                }
                if(set.isEmpty()) break;
                set.add(i);
                for(int k : set){
                    ans[k] = makeAbbr(dict.get(k), ++prefix[k]);
                }
            }
        return Arrays.asList(ans);
    }

    private String makeAbbr(String s, int prefix){
        if(prefix >= s.length() - 2) return s;
        StringBuilder ns=  new StringBuilder();
        ns.append(s.substring(0,prefix));
        ns.append(s.length() - 1 - prefix);
        ns.append(s.charAt(s.length() - 1));
        return  ns.toString();
    }
}
