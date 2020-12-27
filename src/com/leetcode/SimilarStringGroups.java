package com.leetcode;


public class SimilarStringGroups {
    int[] parent;
    public int numSimilarGroups(String[] strs) {
        int output = 0;
        parent = new int[strs.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < strs.length; ++i){
            for(int j = i + 1; j < strs.length; ++j){
                if(similar(strs[i], strs[j]))
                    union(i,j);
            }
        }

//        Set<Integer> groups = new HashSet();
//        for (int i = 0; i < parent.length; i++)
//            groups.add(find(i));
//        System.out.println(groups.size());

        for(int i = 0; i < parent.length; ++i){
            if(parent[i] == i) output++;
        }
        return output;
    }

    public void union(int i, int j){
        int a = find(i);
        int b = find(j);
        if(a != b){
            parent[a] = b;
        }
    }

    public int find(int a){
        if(parent[a] == a) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public boolean similar(String s, String t){
        if(s.length() != t.length()) return false;
        int unmatched = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)) unmatched++;
        }
        return unmatched <= 2;
    }

    public static void main(String[] args){
        String[] arr = {"tars","rats","arts","star"};
        SimilarStringGroups similarStringGroups = new SimilarStringGroups();
        System.out.println(similarStringGroups.numSimilarGroups(arr));
    }
}
