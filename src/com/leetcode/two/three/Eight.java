package com.leetcode.two.three;

public class Eight {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int[] out = new int[nums.length];
        out[0] = 1;
        for(int i = 1;i<nums.length;i++) out[i] = out[i - 1] * nums[i - 1];
        int right = 1;
        for(int i = nums.length - 2;i >= 0;i--){
            right *= nums[i + 1];
            out[i] *= right;
        }
        return out;
    }
}
