package com.leetcode.two.three;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Nine {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        Deque<Integer> q = new LinkedList<>();

        int[] ret = new int[nums.length - k + 1];
        for(int i = 0;i<nums.length;i++){
            if(i >= k){
                while (!q.isEmpty() && q.getLast() <= i - k){
                    q.removeLast();
                }
            }
            while (!q.isEmpty() && nums[q.getFirst()] < nums[i]){
                q.removeFirst();
            }
            q.addFirst(i);
            if(i >= k -1) ret[i - k + 1] = nums[q.getLast()];
        }
        return ret;
    }

}
