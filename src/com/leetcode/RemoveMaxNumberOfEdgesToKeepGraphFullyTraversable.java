package com.leetcode;


import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UF alice = new UF(n);
        UF bob = new UF(n);
        int edgesAdded = 0;
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        for(int[] edge : edges){
            int type = edge[0];
            int a = edge[1];
            int b = edge[2];
            switch (type){
                case 3: if(alice.union(a,b) | bob.union(a,b)){
                    edgesAdded++;
                }break;
                case 2:if(bob.union(a,b)){
                    edgesAdded++;
                }break;
                case 1: if(alice.union(a,b)){
                    edgesAdded++;
                }break;
            }
        }
        return (alice.united() && bob.united()) ? edges.length - edgesAdded : -1;
    }

    public static void main(String[] args){
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable sol = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
        System.out.println(sol.maxNumEdgesToRemove(4,edges));
    }
}

class UF {
    int[] parents;
    int distinctComponents = 0;

    public UF(int n){
        parents = new int[n + 1];
        for(int i = 0; i <= n; ++i)
            parents[i] = i;
        distinctComponents = n;
    }

    public boolean union(int a, int b){
        int x = findParent(a);
        int y = findParent(b);
        if(x != y){
            parents[x] = y;
            distinctComponents--;
            return true;
        }
        return false;
    }

    public int findParent(int id){
        if(id == parents[id]) return id;
        parents[id] = findParent(parents[id]);
        return parents[id];
    }

    public boolean united(){
        return distinctComponents == 1;
    }
}
