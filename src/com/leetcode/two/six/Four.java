package com.leetcode.two.six;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Four {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);

        for(int i = 1;i<n;i++){
            long cur = pq.remove();
            while (!pq.isEmpty() && pq.peek() == cur) pq.remove();
            pq.add(cur * 2);
            pq.add(cur * 3);
            pq.add(cur * 5);
        }
        return pq.remove().intValue();

    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.nthUglyNumber(11));
    }


}
