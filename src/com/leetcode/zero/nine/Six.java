package com.leetcode.zero.nine;

public class Six {
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;


        for(int i = 2;i<=n;i++){
            for(int j = 1;j<=i;j++){
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }

        return nums[n];
    }
}
