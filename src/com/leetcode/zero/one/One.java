package com.leetcode.zero.one;

public class One {
    public int maxArea(int[] height) {
        int l = 0,h = height.length - 1,max = 0;
        while (l < h){
            max = Math.max(max,(h - l + 1) * (Math.min(height[l],height[h])));
            if(height[l] < height[h]) l++;
            else h--;
        }

        return max;
    }
}
