package com.leetcode.zero.three;

public class Three {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0,h = nums.length - 1,biggest = -1;
        while (l <= h){
            int mid = (l + h) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                biggest = mid;
                break;
            }

            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        if(target >= nums[0]){
            return find(nums,0,biggest,target);
        }else{
            return find(nums,biggest + 1,nums.length - 1,target);
        }

    }

    private int find(int[] nums, int l, int h,int target) {
        while (l <= h){
            int mid = (l + h) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
