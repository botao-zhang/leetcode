package com.leetcode.three.four;

public class Three {
    public int integerBreak(int n) {
        int[] ret = new int[n + 1];
        ret[1] = 1;
        for(int i = 2;i<=n;i++){
            int max = 0;
            for(int j = 1;j<i;j++){
                max = Math.max(max,ret[j] * ret[i - j]);
            }
            if(i != n) max = Math.max(i,max);
            ret[i] = max;
        }

        return ret[n];
    }
}
