package com.leetcode.zero.five;


import com.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Six {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) return new ArrayList<>();
        Collections.sort(intervals,(o1, o2) -> o1.start - o2.start);

        List<Interval> ret = new ArrayList<>();
        ret.add(intervals.get(0));

        for(Interval interval : intervals){
            if(interval.start > ret.get(ret.size() - 1).end){
                ret.add(interval);
            }else{
                ret.get(ret.size() - 1).end = Math.max(ret.get(ret.size() - 1).end,interval.end);
            }
        }
        return ret;
    }
}
