package com.leetcode.zero.three;

public class Four {
    public int[] searchRange(int[] nums, int target) {
        int l = 0,h = nums.length - 1,first = -1,last = -1;
        while (l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid - 1] < target){
                    first = mid;
                    break;
                }
                h = mid - 1;
            }else if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        if(first < 0) return new int[]{-1,-1};
        l = first;
        h = nums.length - 1;
        while (l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid + 1] > target){
                    last = mid;
                    break;
                }
                l = mid + 1;
            }else if(nums[mid] > target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return new int[]{first,last};
    }
}
