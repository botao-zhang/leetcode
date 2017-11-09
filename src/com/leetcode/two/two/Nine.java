package com.leetcode.two.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nine {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        int fn = nums[0],sn = 0,fc = 0, sc = 0;

        for(int i = 0;i<nums.length;i++){
            if(fn == nums[i]){
                fc++;
            }else if(sn == nums[i]){
                sc++;
            }else if(fc == 0){
                fn = nums[i];
                fc = 1;
            }else if(sc == 0){
                sn = nums[i];
                sc = 1;
            }else{
                sc--;
                fc--;
            }
        }

        int ft = 0,st = 0;
        for(int num : nums){
            if(num == fn) ft++;
            else if(num == sn) st++;
        }

        if(ft > nums.length / 3) ret.add(fn);
        if(st > nums.length / 3) ret.add(sn);
        return ret;
    }
}
