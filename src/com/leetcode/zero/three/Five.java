package com.leetcode.zero.three;

public class Five {
    public int searchInsert(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                if(mid == 0 || nums[mid - 1] < target) return mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return nums.length;
    }
}
