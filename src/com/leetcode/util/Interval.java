package com.leetcode.util;

public class Interval {
    public int start;
    public int end;
    public Interval(){

    }
    public Interval(int s,int e){
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
