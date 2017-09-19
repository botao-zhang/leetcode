package com.leetcode.zero.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Six {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE,ret = 0;
        for(int first = 0;first < nums.length;first++){
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            int l = first + 1, h = nums.length - 1;
            while (l < h){
                if(l > first + 1 && nums[l] == nums[l - 1]){
                    l++;
                }else if(h < nums.length - 1 && nums[h] == nums[h + 1]){
                    h--;
                }else {
                    int sum = nums[first] + nums[l] + nums[h],diff = sum - target;
                    if(diff == 0) return target;
                    if(Math.abs(diff) < Math.abs(minDiff)){
                        ret = sum;
                        minDiff = diff;
                    }
                    if (sum <= target) l++;
                    else h--;
                }
            }
        }
        return ret;
    }
}
