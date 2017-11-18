package com.leetcode.three.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Zero {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> nums = new HashMap<>();
        for(int num : nums1) nums.put(num,nums.getOrDefault(num,0) + 1);

        List<Integer> dup = new ArrayList<>();

        for(int num : nums2){
            Integer cnt = nums.get(num);
            if(cnt != null && cnt > 0){
                dup.add(num);
                nums.put(num,cnt - 1);
            }
        }

        int[] ret = new int[dup.size()];
        for(int i = 0;i<dup.size();i++) ret[i] = dup.get(i);
        return ret;
    }

}
