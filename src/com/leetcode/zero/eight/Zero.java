package com.leetcode.zero.eight;

public class Zero {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;

        int max = nums[1],len = 2;
        boolean isSecond = nums[1] == nums[0];
        for(int start = 2;start < nums.length;start++){
            if(nums[start] != max || !isSecond) nums[len++] = nums[start];
            if(nums[start] != max){
                max = nums[start];
                isSecond = false;
            }else{
                isSecond = true;
            }
        }
        return len;
    }
}
