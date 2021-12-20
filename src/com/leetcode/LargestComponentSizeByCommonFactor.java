package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] A) {
        int max = Arrays.stream(A).reduce(A[0], Math::max);
        UFWithRankAndPathCompression uf = new UFWithRankAndPathCompression(max);
        for(int num : A){
            for(int i = 2; i < ((int) Math.sqrt(num) + 1); ++i){
                if(num % i == 0){
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int output = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            int group = uf.find(a);
            map.put(group, map.getOrDefault(group, 0) + 1);
            output = Math.max(output, map.get(group));
        }
        return output;
    }

    public static void main(String[] args){
        int[] arr = {4,6,15,35};
        LargestComponentSizeByCommonFactor sol = new LargestComponentSizeByCommonFactor();
        System.out.println(sol.largestComponentSize(arr));
    }
}

class UFWithRankAndPathCompression {
    int[] parents;
    int[] size;
    public UFWithRankAndPathCompression(int n){
        parents = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i <= n; ++i){
            this.parents[i] = i;
            this.size[i] = 1;
        }
    }

    public void union(int a, int b){
        int x = find(a), y = find(b);
        if(x != y){
            if(size[x] > size[y]){
                int temp = y;
                y = x;
                x = temp;
            }
            parents[x] = y;
            size[y] += size[x];
        }

    }

    public int find(int id){
        if(id == this.parents[id]) return id;
        this.parents[id] = find(this.parents[id]);
        return this.parents[id];
    }
}
