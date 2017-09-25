package com.leetcode.zero.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zero {
    private void helper(int[] nums,int offset,int target,List<Integer> now,List<List<Integer>> ret){
        if(offset == nums.length){
            if(target == 0) ret.add(new ArrayList<>(now));
            return;
        }

        if(now.isEmpty()  || nums[offset] != now.get(now.size() - 1)) {
            helper(nums, offset + 1, target, now, ret);
        }

        if(nums[offset] > target) return;
        now.add(nums[offset]);
        helper(nums,offset + 1,target - nums[offset],now,ret);
        now.remove(now.size() - 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        //HashMap<Integer,List<Integer>>[] cache = new HashMap[candidates.length];
        helper(candidates,0,target,new ArrayList<>(),ret);
        return ret;
    }
}
