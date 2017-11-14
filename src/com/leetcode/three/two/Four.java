package com.leetcode.three.two;

import java.util.Arrays;

public class Four {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length / 2;
        int i = nums[mid - 1];
        if(nums.length % 2 == 0)


    }

    public static void main(String[] args) {
        Four four = new Four();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        four.wiggleSort(nums);

    }
}
