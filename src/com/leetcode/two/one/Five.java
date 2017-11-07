package com.leetcode.two.one;

import java.util.Arrays;

public class Five {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
