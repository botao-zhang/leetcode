package com.leetcode.zero.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Nine {

    private void helper(int[] nums,int offset,int target,List<Integer> now,List<List<Integer>> ret){
        if(target == 0) ret.add(new ArrayList<>(now));
        if(offset == nums.length) return;
        if(nums[offset] > target) return;

        for(int i = 0;i<=target / nums[offset];i++){
            if(i > 0) now.add(nums[offset]);
            helper(nums,offset + 1,target - i * nums[offset],now,ret);
        }

        for(int i = 0;i<target / nums[offset];i++){
            now.remove(now.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        //HashMap<Integer,List<Integer>>[] cache = new HashMap[candidates.length];
        helper(candidates,0,target,new ArrayList<>(),ret);
        return ret;
    }
}
