package com.leetcode.three.three;

public class Zero {
    public int minPatches(int[] nums, int n){
        long missing = 1,patch = 0;
        for(int i = 0;i<nums.length;i++) {
            if (nums[i] <= missing) missing += nums[i];
            else{
                missing += missing;
                patch++;
                i--;
            }
            if(missing > n) break;
        }

        while (missing <= n){
            missing *= 2;
            patch++;
            System.out.println("missing = " + missing +  " patch = "+ patch);

        }
        return (int)patch;
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.minPatches(new int[]{1,3},6));
        System.out.println(zero.minPatches(new int[]{1,5},10));
        System.out.println(zero.minPatches(new int[]{1,2,2},5));
        System.out.println(zero.minPatches(new int[]{},8));
        System.out.println(zero.minPatches(new int[]{4,5,7,7,9,11,12,33,35,39,40,50,54,59,60,60,66,70,71,72,77,78,81,84,84,84,85,88,95,96,96},36));
    }
}
