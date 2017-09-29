package com.leetcode.zero.four;

import java.util.ArrayList;
import java.util.List;

public class Six {
    private void help(int[] nums,List<Integer> cur, boolean[] in,List<List<Integer>> ret){
        if(cur.size() == nums.length){
            ret.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0;i<nums.length;i++){
            if(!in[i]){
                in[i] = true;
                cur.add(nums[i]);
                help(nums,cur,in,ret);
                in[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        help(nums,new ArrayList<>(),new boolean[nums.length],ret);
        return ret;
    }
}
