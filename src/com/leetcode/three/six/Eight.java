package com.leetcode.three.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Eight {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        List<Integer>[] list = new List[nums.length];
        for(int i = 0;i<nums.length;i++){
            list[i] = new ArrayList<>();
            list[i].add(nums[i]);
        }

        for(int i = nums.length - 2;i>=0;i--){
            List<Integer> maxList = null;
            for(int j = i + 1;j<nums.length;j++){
                if(nums[j] % nums[i] == 0){
                    if(maxList == null || list[j].size() > maxList.size()){
                        maxList = list[j];
                    }
                }
            }

            if(maxList != null) list[i].addAll(maxList);
        }

        List<Integer> ret = list[list.length - 1];
        for(int i = list.length - 2;i>=0;i--){
            if(list[i].size() > ret.size()) ret = list[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.largestDivisibleSubset(new int[]{1,2,3}));
    }
}
