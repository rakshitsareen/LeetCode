package com.leetcode;

import java.util.TreeMap;

public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h: hand){
            map.put(h, map.getOrDefault(h,0)+ 1);
        }
        for(int it : map.keySet()){
            if(map.get(it) > 0){
                for(int i = W - 1; i >= 0; --i){
                    if(map.getOrDefault(it+i, 0) < map.get(it))return false;
                    map.put(it + i, map.get(it+i) - map.get(it));
                }
            }
        }
        return true;
    }
}
