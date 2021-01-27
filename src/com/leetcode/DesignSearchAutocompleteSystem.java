package com.leetcode;

import java.util.*;

public class DesignSearchAutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode(){
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times){
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i < sentences.length; ++i){
            add(sentences[i], times[i]);
        }
    }

    class Pair {
        String s;
        int count;

        public Pair(String s,  int count){
            this.s = s;
            this.count = count;
        }
    }

    TrieNode root;
    String prefix;

    public void add(String s, int count){
        TrieNode curr = root;
        for(char c : s.toCharArray()){
            TrieNode next = curr.children.get(c);
            if(next == null){
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }
    public List<String> input(char c){
        if(c == '#'){
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode curr = root;
        for(char cc : prefix.toCharArray()){
            TrieNode next = curr.children.get(cc);
            if(next == null) return new ArrayList<>();
            curr = next;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                (a,b) -> a.count == b.count ? a.s.compareTo(b.s) : b.count - a.count);
        for(String s : curr.counts.keySet()){
            queue.add(new Pair(s, curr.counts.get(s)));
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 3 && !queue.isEmpty(); ++i){
            res.add(queue.poll().s);
        }
        return res;
    }
}