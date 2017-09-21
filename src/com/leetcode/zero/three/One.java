package com.leetcode.zero.three;

import java.util.Arrays;

public class One {
    public void nextPermutation(int[] nums) {
        int lastV = -1;
        for(int i = 0;i<nums.length - 1;i++){
            if(nums[i] < nums[i + 1]) lastV = i;
        }

        if(lastV < 0) Arrays.sort(nums);
        else{
            int swap = nums.length - 1;
            for(int i = lastV + 1;i<nums.length;i++){
                if(nums[lastV] >= nums[i]){
                    swap = i - 1;
                    break;
                }
            }
            System.out.println("last v = " + lastV + " swap = " + swap);
            int tmp = nums[lastV];
            nums[lastV] = nums[swap];
            nums[swap] = tmp;
            System.out.println("after swap nums = " + Arrays.toString(nums));
            Arrays.sort(nums,lastV + 1,nums.length);
        }
    }

    public static void main(String[] args) {
        One one = new One();
        int[] input = new int[]{2,3,1};
        one.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}
