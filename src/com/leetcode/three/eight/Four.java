package com.leetcode.three.eight;

import java.util.Random;

public class Four {
    static class Solution{
        int[] arr;
        public Solution(int[] nums) {
            arr = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return arr;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] ret = new int[arr.length];
            boolean[] used = new boolean[arr.length];
            Random r = new Random();
            int i = 0;
            while (i < ret.length){
                int idx = r.nextInt(arr.length);
                if(!used[idx]){
                    ret[i++] = arr[idx];
                    used[idx] = true;
                }
            }
            return ret;
        }
    }
}
