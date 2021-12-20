package com.leetcode;

import java.util.*;

public class FindCriticalAndPseudoCriticalEdgesMST {
    class UF {
        int[] parents;
        int count;
        public UF(int n){
            parents = new int[n];
            count = n;
            for(int i = 0; i < n; ++i)
                parents[i] = i;
        }

        public int find(int id){
            if(parents[id] == id) return id;
            parents[id] = find(parents[id]);
            return parents[id];
        }

        public boolean union(int a, int b){
            int x = find(a);
            int y = find(b);
            if(x!=y){
                parents[x] = y;
                count--;
                return true;
            }
            else
                return false;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> criticals = new ArrayList<>();
        List<Integer> psuedos = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            map.put(edges[i], i);
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int minCost = buildMST(n,edges, null, null);
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            int index = map.get(edge);
            int costWithoutEdge = buildMST(n, edges, null, edge);
            if(minCost < costWithoutEdge)
                criticals.add(index);
            else {
                int cost = buildMST(n, edges, edge, null);
                if(cost == minCost) psuedos.add(index);
            }
        }
        return Arrays.asList(criticals, psuedos);
    }

    private int buildMST(int n, int[][] edges, int[] pick, int[] skip){
        UF uf = new UF(n);
        int cost = 0;
        if(pick != null){
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        for(int[] edge : edges){
            if(edge != skip && uf.union(edge[0], edge[1]))
                cost += edge[2];
        }
        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }
}
