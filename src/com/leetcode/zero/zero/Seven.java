package com.leetcode.zero.zero;

public class Seven {
    public int reverse(int x) {
        long tmp = 0,ori = x;
        boolean isNeg = x < 0;
        if(isNeg) ori = -1 * ori;

        while (ori != 0){
            tmp = tmp * 10 + ori % 10;
            ori /= 10;
        }

        if(isNeg) tmp *= -1;
        if(tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE) return 0;
        return (int) tmp;
    }
}
