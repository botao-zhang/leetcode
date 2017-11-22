package com.leetcode.three.seven;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Three {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
            }
        });

        for(int i = 0;i<nums1.length;i++) pq.add(new int[]{i,0});

        List<int[]> ret = new ArrayList<>();
        while (!pq.isEmpty() && ret.size() < k){
            int[] set = pq.poll();
            if(set[1] < nums2.length - 1) pq.add(new int[]{set[0],set[1] + 1});
            ret.add(new int[]{nums1[set[0]],nums2[set[1]]});
        }
        return ret;
    }
}
