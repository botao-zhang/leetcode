package com.leetcode.zero.five;

import com.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seven {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();

        for(Interval existing : intervals){
            if(newInterval == null || existing.end < newInterval.start) ret.add(existing);
            else{
                if(existing.start <= newInterval.end){
                    newInterval.start = Math.min(newInterval.start,existing.start);
                    newInterval.end = Math.max(newInterval.end,existing.end);
                }else{
                    ret.add(newInterval);
                    newInterval = null;
                    ret.add(existing);
                }
            }
        }

        if(newInterval != null) ret.add(newInterval);
        return ret;
    }

    public static void main(String[] args) {
        Seven seven = new Seven();
        System.out.println(seven.insert(Arrays.asList(new Interval[]{new Interval(1,3),new Interval(6,9)}),new Interval(2,5)));
    }
}
