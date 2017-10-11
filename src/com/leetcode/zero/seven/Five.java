package com.leetcode.zero.seven;

import java.util.Arrays;

public class Five {
    public void sortColors(int[] nums) {
        int[] cnts = new int[3];
        for(int n : nums) cnts[n]++;

        int idx = 0;
        for(int j = 0;j<=2;j++){
            for(int i = 0;i<cnts[j];i++) nums[idx++] = j;
        }
    }

    public static void main(String[] args) {
        Five five = new Five();
        five.sortColors(new int[]{2,0});
    }

}
