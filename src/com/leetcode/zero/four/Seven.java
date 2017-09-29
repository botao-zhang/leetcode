package com.leetcode.zero.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Seven {
    private void help(int[] nums,List<Integer> cur,HashMap<Integer,Integer> cnt,List<List<Integer>> ret){
        if(cur.size() == nums.length){
            ret.add(new ArrayList<>(cur));
            return;
        }
        for(int num : cnt.keySet()){
            int curCnt = cnt.get(num);
            if(curCnt > 0 && (cur.isEmpty() || cur.get(cur.size() - 1) != num)){
                for(int i = 1;i<=curCnt;i++){
                    cur.add(num);
                    cnt.put(num,curCnt - i);
                    help(nums,cur,cnt,ret);
                }
                for(int i = 1;i<=curCnt;i++) cur.remove(cur.size() - 1);
                cnt.put(num,curCnt);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        HashMap<Integer,Integer> cnt = new HashMap<>();
        for(int num : nums) cnt.put(num,cnt.getOrDefault(num,0) + 1);
        help(nums,new ArrayList<Integer>(),cnt,ret);
        return ret;
    }
}
