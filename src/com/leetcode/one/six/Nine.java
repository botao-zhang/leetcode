package com.leetcode.one.six;

public class Nine {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return -1;
        int count = 1,pivotal = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == pivotal) count++;
            else{
                count--;
                if(count == 0){
                    count = 1;
                    pivotal = nums[i];
                }
            }
        }
        return pivotal;
    }
}
