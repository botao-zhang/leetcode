package com.leetcode.two.zero;

public class Nine {
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0,slow = 0,min = nums.length + 1,sum = 0;
        while (fast < nums.length){
            sum += nums[fast];
            if(sum >= s){
                while (sum - nums[slow] >= s){
                    sum -= nums[slow];
                    slow++;
                }
                min = Math.min(fast - slow + 1,min);
            }
            fast++;
        }
        if(min > nums.length) return 0;
        return min;
    }
}
