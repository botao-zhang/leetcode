package com.leetcode.two.six;

public class Eight {
    public int missingNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            int v = nums[i];
            if(v >= 0 && v < nums.length && nums[v] != v){
                int tmp = nums[v];
                nums[v] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for(int i = 0;i<nums.length;i++) if(nums[i] != i) return i;
        return nums.length;
    }
}
