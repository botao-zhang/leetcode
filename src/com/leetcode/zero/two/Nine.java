package com.leetcode.zero.two;

public class Nine {
    private int helper(long n1,long n2){
        if(n2 == 1) return (int) n1;
        if(n1 < n2) return 0;

        int ret = 1;
        long divisor = n2;
        while (n1 >= (divisor << 1)){
            ret = ret << 1;
            divisor = divisor << 1;
        }

        return ret + helper(n1 - divisor,n2);
    }

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;

        return sign * helper(Math.abs((long)dividend),Math.abs((long) divisor));
    }
}
