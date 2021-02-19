package com.leetcode;

import java.util.*;

public class AccountsMerge {
    static class DSU {
        int[] parents;
        public DSU(){
            parents = new int[10001];
            for(int i = 0; i < 10001; ++i)
                parents[i] = i;
        }
        public int find(int id){
            if(id != parents[id])
                id = find(parents[id]);
            return id;
        }
        public void union(int x, int y){
            int xp = find(x);
            int yp = find(y);
            parents[xp] = yp;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU unionFind = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for(List<String> account : accounts){
            String name = "";
            for(String email : account){
                if(name.equals("")){
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email, id++);
                }
                unionFind.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        Map<Integer, List<String>> result = new HashMap<>();
        for(String email : emailToName.keySet()){
            int index = unionFind.find(emailToId.get(email));
            result.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for(List<String> list : result.values()){
            Collections.sort(list);
            list.add(0, emailToName.get(list.get(0)));
        }
        return new ArrayList<>(result.values());
    }

    public static void main(String[] args){
        /*
        [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
        ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
        ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
        ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
        ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
         */
        List<List<String>> input = new ArrayList<>();
        input.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        input.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
        input.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        input.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        input.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> result = accountsMerge.accountsMerge(input);
        for(List<String> strings : result){
            for(String s : strings)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
