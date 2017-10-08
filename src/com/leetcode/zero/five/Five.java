package com.leetcode.zero.five;

public class Five {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int cur = 0,next = nums[0];

        while (next < nums.length - 1){
            int n = 0;
            for(int i = cur + 1;i<=next;i++){
                n = Math.max(i + nums[i],n);
            }

            if(n <= next) return false;

            cur = next;
            next = n;
        }
        return true;
    }
}
