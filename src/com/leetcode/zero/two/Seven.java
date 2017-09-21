package com.leetcode.zero.two;

public class Seven {
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val) nums[cur++] = nums[i];
        }
        return cur;
    }
}
