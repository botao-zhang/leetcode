package com.leetcode.two.two;

import java.util.TreeMap;
import java.util.TreeSet;

public class Zero {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0;i<nums.length;i++){
            if(i > k) set.remove((long)nums[i - k -1]);
            Long large = set.higher((long)nums[i] - t - 1);
            System.out.println("large = " + large);
            if(large != null && large <= nums[i] + t) return true;

            Long small = set.lower((long)nums[i] + t + 1);
            if(small != null && small >= nums[i] - t) return true;
            set.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.containsNearbyAlmostDuplicate(new int[]{2,0,-2,2},2,1));
        System.out.println(zero.containsNearbyAlmostDuplicate(new int[]{0,Integer.MAX_VALUE},1,Integer.MAX_VALUE));
    }
}
