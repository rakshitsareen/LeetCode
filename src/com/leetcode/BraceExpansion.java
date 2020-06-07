package com.leetcode;

import java.util.Set;
import java.util.TreeSet;

public class BraceExpansion {
    public String[] expand(String S) {
        Set<String> set = new TreeSet<>();
        if(S.length() == 0) return new String[]{""};
        if(S.length() == 1) return new String[]{S};
        if(S.charAt(0) == '{'){
            int i = 0;
            while(S.charAt(i)!='}')i++;
            String sub = S.substring(1,i);
            String[] strs = expand(S.substring(i + 1));
            String[] subs = sub.split(",");
            for(String s : subs)
                for(String t : strs)
                    set.add(s + t);
        }
        else {
            String[] strs = expand(S.substring(1));
            for(String s : strs)
                set.add(S.charAt(0) + s);
        }
        return set.toArray(new String[0]);
    }
}
