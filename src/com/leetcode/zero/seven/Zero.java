package com.leetcode.zero.seven;

public class Zero {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int nextNext = 1,next = 2;

        for(int i = n - 3;i>=0;i--){
            int sum = nextNext + next;
            nextNext = next;
            next = sum;
        }
        return next;
    }
}
