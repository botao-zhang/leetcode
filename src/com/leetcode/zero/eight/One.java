package com.leetcode.zero.eight;

import java.util.Arrays;

public class One {
    private int findMin(int nums[],int l,int h, int first){
        System.out.println("l = " + l + " h = " + h);
        if(l > h) return -1;

        int mid = (l + h) / 2;
        if(nums[mid] < first){
            if(nums[mid] < nums[mid - 1]) return mid;
            return findMin(nums,l,mid - 1,first);
        }
        return findMin(nums,mid + 1,h,first);

    }

    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;

        int minIdx = 0,l = 0, h = nums.length - 1;
        while (h > 0 && nums[h] == nums[0]) h--;
        minIdx = findMin(nums,0,h,nums[0]);
        if(minIdx <= 0) {
            return Arrays.binarySearch(nums,0,h+1,target) >= 0;
        }
        if(target >= nums[0]) return Arrays.binarySearch(nums,0,minIdx,target) >= 0;
        return Arrays.binarySearch(nums,minIdx,h + 1,target) >= 0;
    }

}
