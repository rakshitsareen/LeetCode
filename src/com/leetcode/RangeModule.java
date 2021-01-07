package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class RangeModule {

    TreeSet<LocalInterval> set;

    public RangeModule() {
        set = new TreeSet<>();
    }

    public void addRange(int left, int right) {
        Iterator<LocalInterval> itr = set.tailSet(new LocalInterval(0,  left)).iterator();
        while(itr.hasNext()){
            LocalInterval iv = itr.next();
            if(right < iv.left) break;
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        set.add(new LocalInterval(left, right));
    }

    public boolean queryRange(int left, int right) {
        LocalInterval iv = set.higher(new LocalInterval(0,  left));
        return (iv != null && iv.left <= left && iv.right >= right);
    }

    public void removeRange(int left, int right) {
        ArrayList<LocalInterval> todo = new ArrayList<>();
        Iterator<LocalInterval> itr = set.tailSet(new LocalInterval(0, left)).iterator();
        while(itr.hasNext()){
            LocalInterval iv = itr.next();
            if(right < iv.left) break;
            if(left > iv.left) todo.add(new LocalInterval(iv.left, left));
            if(right < iv.right) todo.add(new LocalInterval(right, iv.right));
            itr.remove();
        }
        for(LocalInterval iv : todo) set.add(iv);
    }
}

class LocalInterval implements Comparable<LocalInterval> {
    int left;
    int right;

    public LocalInterval(int left, int right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(LocalInterval that) {
        if(this.right == that.right) return this.left - that.left;
        return this.right - that.right;
    }
}
