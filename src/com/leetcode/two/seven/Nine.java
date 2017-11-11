package com.leetcode.two.seven;

import java.util.HashMap;

public class Nine {
    HashMap<Integer,Integer> cnt = new HashMap<>();
    public int numSquares(int n) {
        if(cnt.containsKey(n)) return cnt.get(n);

        int sq = (int) Math.sqrt(n), left = n - sq * sq;
        if(left == 0) return 1;

        int min = n;
        for(int i = sq;i>=1;i--){
            left = n - i * i;
            min = Math.min(min,1 + numSquares(left));
        }
        cnt.put(n,min);
        return min;
    }
}
