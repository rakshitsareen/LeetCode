package com.leetcode;

import java.util.*;

public class OpentheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String s = queue.poll();
                if (deads.contains(s)) {
                    size--;
                    continue;
                }
                if (s.equals(target)) return level;
                StringBuilder stringBuilder = new StringBuilder(s);
                for (int i = 0; i < 4; ++i) {
                    char c = stringBuilder.charAt(i);
                    String s1 = stringBuilder.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + stringBuilder.substring(i + 1);
                    String s2 = stringBuilder.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + stringBuilder.substring(i + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        String[] d = {"8888"};
        System.out.println(new OpentheLock().openLock(d, "0009"));
    }
}
