package com.leetcode.one.nine;

public class Eight {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int[] sum = new int[nums.length + 1];
        sum[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i>=0;i--){
            sum[i] = Math.max(sum[i + 1],nums[i] + sum[i + 2]);
        }

        return sum[0];

    }
}
