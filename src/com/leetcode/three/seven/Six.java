package com.leetcode.three.seven;

public class Six {
    private int cnt(int[] nums,boolean larger){
        int tar = nums[0], cnt = 1, cur =1;
        while (cur < nums.length){
            if(larger){
                if(nums[cur] > tar){
                    cnt++;
                    larger = false;
                }
            }else{
                if(nums[cur] < tar){
                    cnt++;
                    larger = true;
                }
            }
            tar = nums[cur++];
        }
        return cnt;
    }

    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 0) return nums.length;

        int lcnt = cnt(nums,true),scnt = cnt(nums,false);
        return Math.max(lcnt,scnt);
    }
}
