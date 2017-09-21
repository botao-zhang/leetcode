package com.leetcode.zero.two;

public class Six {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int lastIn = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[lastIn]) nums[++lastIn] = nums[i];
        }
        return lastIn + 1;
    }
}
