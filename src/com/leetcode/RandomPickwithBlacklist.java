package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickwithBlacklist {
    int M; Random random; Map<Integer, Integer> map;

    public RandomPickwithBlacklist(int N, int[] blacklist) {
        map = new HashMap<>();
        for(int b : blacklist)
            map.put(b, -1);
        M = N - map.size();
        for(int b : blacklist){
            if(b < M){
                // we have to remap this blacklisted number
                while(map.containsKey(N -1)) N--;
                map.put(b, N - 1);
                N--;
            }
        }
        random = new Random();
    }

    public int pick() {
        int r = random.nextInt(M);
        if(map.containsKey(r)) return map.get(r);
        return r;
    }
}
