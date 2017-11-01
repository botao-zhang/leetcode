package com.leetcode.one.five;

import java.util.Stack;

public class Two {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE,firstNeg = 0,cur = 1;
        for(int i = 0;i<nums.length;i++){
            cur *= nums[i];
            if(cur == 0){
                max = Math.max(max,0);
                cur = 1;
                firstNeg = 0;
            }else{
                if(cur < 0){
                    if(firstNeg == 0){
                        firstNeg = cur;
                    }
                    else max = Math.max(max,cur / firstNeg);
                }
                max = Math.max(max,cur);
            }

            System.out.println("i = " + i + " cur = " + cur + " max = " + max);
        }
        return max;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.maxProduct(new int[]{2,-5,-2,-4,3}));
        System.out.println(two.maxProduct(new int[]{2,-5,-2,-4,3,0,-1,5,-100}));
        System.out.println(two.maxProduct(new int[]{-100,0,-1}));
    }
}
