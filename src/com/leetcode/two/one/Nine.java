package com.leetcode.two.one;

import java.util.HashSet;

public class Nine {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        k = Math.min(k,nums.length - 1);
        for(int i = 0;i<=k;i++) if(!set.add(nums[i])) return true;
        for(int i = k +1;i<nums.length;i++){
            set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }

        return false;
    }
}