package com.leetcode.three.zero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Zero {
    public int lengthOfLIS(int[] nums) {
        int[] kth = new int[nums.length];
        Arrays.fill(kth, Integer.MAX_VALUE);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int max = 0;
        for(int n : nums){
            System.out.println("n = " + n + " map = " + map);
            Map.Entry<Integer,Integer> entry = map.lowerEntry(n);
            int k = 1;
            if(entry != null) k += entry.getValue();
            if(n < kth[k - 1]){
                map.remove(kth[k - 1]);
                kth[k - 1] = n;
                map.put(n,k);
            }
            max = Math.max(max,k);
        }
        return max;
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
