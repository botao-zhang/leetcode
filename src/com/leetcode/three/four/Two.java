package com.leetcode.three.four;

public class Two {
    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;
        int order = (int) (Math.log(num) / Math.log(4));
        int to = (int) Math.pow(4,order);

        return num == to;

    }
}
