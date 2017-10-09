package com.leetcode.zero.six;

public class Nine {
    public int mySqrt(int x) {
        int lo = 0,hi = x;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            long sq = (long) mid * (long)mid;
            if(sq > x ) hi = mid - 1;
            else lo = mid + 1;
        }
        return hi;
    }
}
