package com.leetcode.two.zero;

public class One {
    public int rangeBitwiseAnd(int m, int n) {
        int ret = 0;
        for(int i = 31;i>=0;i--){
            int mask = 1 << i;
            if((m & mask) > 0 && (n & mask) > 0) ret |= mask;
            else if((m & mask) > 0 || (n & mask) > 0) break;
        }

        return ret;

    }
}
