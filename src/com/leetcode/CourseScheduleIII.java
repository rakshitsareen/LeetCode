package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b - a);
        int time = 0;
        for(int[] c : courses){
            time += c[0];
            priorityQueue.add(c[0]);
            if(time > c[1]) time -= priorityQueue.poll();
        }
        return priorityQueue.size();
    }
}
