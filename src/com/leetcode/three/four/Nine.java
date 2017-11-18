package com.leetcode.three.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Nine {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums = new HashSet<>();
        for(int num : nums1) nums.add(num);

        List<Integer> dup = new ArrayList<>();

        for(int num : nums2) if(nums.remove(num)) dup.add(num);

        int[] ret = new int[dup.size()];
        for(int i = 0;i<dup.size();i++) ret[i] = dup.get(i);
        return ret;
    }
}
