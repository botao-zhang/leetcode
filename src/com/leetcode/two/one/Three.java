package com.leetcode.two.one;

import java.util.ArrayList;
import java.util.Arrays;

public class Three {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] max = new int[nums.length + 1];
        max[1] = nums[0];
        for(int i = 1;i<nums.length - 1;i++){
            max[i + 1] = Math.max(max[i],nums[i] + max[i - 1]);
        }

        int[] max2 = new int[nums.length + 1];
        max2[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2;i>0;i--){
            max2[i] = Math.max(max2[i + 1],nums[i] + max2[i + 2]);
        }

        return Math.max(max[nums.length - 1],max2[1]);

    }

}
