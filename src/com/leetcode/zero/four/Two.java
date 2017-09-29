package com.leetcode.zero.four;

public class Two {
    public int trap(int[] height) {
        int[] left = new int[height.length], right = new int[height.length];
        for(int i = 1;i<height.length;i++) left[i] = Math.max(left[i - 1],height[i - 1]);
        for(int i = height.length - 2;i>=0;i--) right[i] = Math.max(right[i + 1],height[i + 1]);

        int sum = 0;
        for(int i = 0;i<height.length;i++) sum+=Math.max(0,Math.min(left[i],right[i]) - height[i]);
        return sum;
    }
}
