package com.leetcode.three.five;

import com.leetcode.util.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Two {
    static class  SummaryRanges {

        TreeMap<Integer,Interval> map = new TreeMap<>();
        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            Map.Entry<Integer,Interval> prev = map.floorEntry(val);
            boolean merged = false;
            if(prev != null){
                //System.out.println("val = "+ val + " prev = " + prev);
                Interval interval = prev.getValue();
                if(interval.end >= val) return;
                if(interval.end == val - 1){
                    interval.end = val;
                    merged = true;
                }
            }

            Interval next = map.get(val + 1);
            if(next != null){
                map.remove(val + 1);
                if(prev != null && prev.getValue().end == val){
                    prev.getValue().end = next.end;
                }else{
                    map.put(val,new Interval(val,next.end));
                }
                return;
            }
            if(!merged) map.put(val,new Interval(val,val));
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(3);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(7);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(2);
        System.out.println(summaryRanges.getIntervals());
        summaryRanges.addNum(6);
        System.out.println(summaryRanges.getIntervals());
    }
}
