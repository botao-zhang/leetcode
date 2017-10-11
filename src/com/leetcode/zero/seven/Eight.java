package com.leetcode.zero.seven;

import java.util.ArrayList;
import java.util.List;

public class Eight {
    private void help(int[] nums,int off,List<Integer> cur,List<List<Integer>> ret){
        if(off == nums.length){
            ret.add(new ArrayList<>(cur));
        }else{
            help(nums,off + 1,cur,ret);
            cur.add(nums[off]);
            help(nums,off + 1,cur,ret);
            cur.remove(cur.size() - 1);
        }
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        help(nums,0,new ArrayList<>(),ret);
        return ret;
    }
}
