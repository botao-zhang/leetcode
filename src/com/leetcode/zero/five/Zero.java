package com.leetcode.zero.five;

public class Zero {
    private double help(double x,long n){
        if(n == 0) return 1;

        double half = help(x,n / 2);

        double ret = half * half;
        if(n % 2 == 1) ret *= x;

        return ret;
    }

    public double myPow(double x, int n) {

        if(n < 0){
            return 1 / help(x,-1L * (long)n);
        }

        return help(x,n);

    }
}
