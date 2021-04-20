package com.leetcode;

import javafx.util.Pair;

import java.util.*;

public class MakingALargeIsland {
    public int N = 0;
    public int largestIsland(int[][] grid) {
        N = grid.length;
        Map<Integer, Integer> area = new HashMap<>();
        int index = 3; int res = 0;
        for(int i = 0; i < N; ++i) for(int j = 0; j < N; ++j){
            if(grid[i][j] == 1){
                area.put(index,dfs(grid, i,j, index));
                res = Math.max(res, area.get(index++));
            }
        }
        for(int i = 0; i < N; ++i) for(int j = 0; j < N; ++j)
            if(grid[i][j] == 0){
                Set<Integer> seen = new HashSet<>();
                int cur = 1;
                for(Pair<Integer,Integer>pair : move(i,j)){
                    index = grid[pair.getKey()][pair.getValue()];
                    if(index > 1 && !seen.contains(index)){
                        seen.add(index);
                        cur += area.get(index);
                    }
                }
                res = Math.max(res, cur);
            }
        return res;
    }

    private int dfs(int[][] grid, int x, int y, int index){
        int area = 0;
        grid[x][y] = index;
        for(Pair<Integer, Integer> pair : move(x,y)){
            if(grid[pair.getKey()][pair.getValue()] == 1)
                area += dfs(grid, pair.getKey(), pair.getValue(), index);
        }
        return area + 1;
    }

    private boolean isValid(int x, int y){
        return 0 <= x && x< N && 0 <= y && y < N;
    }

    private List<Pair<Integer, Integer>> move(int x, int y){
        ArrayList<Pair<Integer, Integer>> output = new ArrayList<>();
        if(isValid(x,y + 1)) output.add(new Pair<>(x,y + 1));
        if(isValid(x,y - 1)) output.add(new Pair<>(x,y - 1));
        if(isValid(x + 1,y)) output.add(new Pair<>(x + 1,y));
        if(isValid(x - 1,y)) output.add(new Pair<>(x - 1,y));
        return output;
    }
}
