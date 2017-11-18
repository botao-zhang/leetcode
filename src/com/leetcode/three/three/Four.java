package com.leetcode.three.three;

public class Four {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int two = nums[0],three = Integer.MAX_VALUE;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] > three) return true;
            if(nums[i] > two){
                three = Math.min(three,nums[i]);
            }else{
                two = Math.min(two,nums[i]);
            }
        }
        return false;
    }
}
