package com.leetcode.two.eight;

public class Three {
    public void moveZeroes(int[] nums) {
        int i = 0,j = 0;
        while (i < nums.length){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
            i++;
        }

        while (j < nums.length) nums[j++] = 0;
    }
}
