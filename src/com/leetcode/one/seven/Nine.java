package com.leetcode.one.seven;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Nine {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString(),s2 = o2.toString() + o1.toString();
                return s2.compareTo(s1);
            }
        });

        for(int num : nums) pq.add(num);

        StringBuilder stringBuilder = new StringBuilder();
        while (!pq.isEmpty()) stringBuilder.append(pq.remove());

        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0'){
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}
