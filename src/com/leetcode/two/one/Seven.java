package com.leetcode.two.one;

import java.util.HashSet;

public class Seven {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) if(!set.add(num)) return true;
        return false;
    }
}
