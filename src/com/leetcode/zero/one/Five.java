package com.leetcode.zero.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Five {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int first = 0;first < nums.length;first++){
            if(first > 0 && nums[first] == nums[first - 1]) continue;
            int l = first + 1, h = nums.length - 1;
            while (l < h){
                if(l > first + 1 && nums[l] == nums[l - 1]){
                    l++;
                }else if(h < nums.length - 1 && nums[h] == nums[h + 1]){
                    h--;
                }else {
                    int sum = nums[first] + nums[l] + nums[h];
                    if (sum == 0) ret.add(Arrays.asList(nums[first], nums[l], nums[h]));
                    if (sum <= 0) l++;
                    else h--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
