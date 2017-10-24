package com.leetcode.zero.nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zero {
    private void help(int[] nums,int offset,int skipTo,List<Integer> cur,List<List<Integer>> ret){
        if(offset == nums.length){
            ret.add(new ArrayList<>(cur));
            return;
        }

        help(nums,offset + 1,nums[offset],cur,ret);


        if(nums[offset] > skipTo) {
            cur.add(nums[offset]);
            help(nums, offset + 1, skipTo, cur, ret);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        help(nums,0,Integer.MIN_VALUE,new ArrayList<>(),ret);
        return ret;
    }

    public static void main(String[] args) {
        Zero zero = new Zero();
        System.out.println(zero.subsetsWithDup(new int[]{1,2,2}));
    }
}
