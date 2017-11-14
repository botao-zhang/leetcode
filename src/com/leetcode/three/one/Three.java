package com.leetcode.three.one;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Three {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 0) return 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);

        int last = 0;
        for(int i = 1;i<=n;i++){
            long num = pq.remove();
            if(num > last){
                last = (int) num;
                for(int p : primes){
                    pq.add((long) last * (long)p);
                }
            }else{
                i--;
            }

        }
        return last;

    }
}
