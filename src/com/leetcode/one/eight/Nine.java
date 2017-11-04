package com.leetcode.one.eight;

public class Nine {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int[] tmp = new int[k];
        for(int i = nums.length - k;i<nums.length;i++) tmp[i - nums.length + k] = nums[i];

        for(int i = nums.length - 1;i>=k;i--)nums[i] = nums[i - k];

        for(int i = 0;i<k;i++) nums[i] = tmp[i];
    }
}
