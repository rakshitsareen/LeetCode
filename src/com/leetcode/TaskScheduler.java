package com.leetcode;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] cf = new int[26];
        int max = 0, maxCount = 0;
        for(char task : tasks){
            cf[task - 'A']++;
            if(max == cf[task - 'A']){
                maxCount++;
            }
            else if(max < cf[task - 'A']){
                max = cf[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = max - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availaibleTasks = tasks.length - max * maxCount;
        int idle = Math.max(0, emptySlots - availaibleTasks);
        return tasks.length + idle;
    }

    public static void main(String[] args){
        char[] chars = {'A','A','A','B','B','B'};
        System.out.println(TaskScheduler.leastInterval(chars, 2));
    }
}
