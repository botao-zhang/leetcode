package com.leetcode.three.seven;

import java.util.Arrays;
import java.util.HashMap;

public class Seven {
    private int cnt(int[] nums,int target,HashMap<Integer,Integer> cache){
        if(target == 0) return 1;
        if(cache.containsKey(target)) return cache.get(target);
        int cnt = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > target) break;
            cnt += cnt(nums,target - nums[i],cache);
        }
        cache.put(target,cnt);
        return cnt;
    }
    public int combinationSum4(int[] nums, int target) {
        if(target <= 0) return 0;
        Arrays.sort(nums);
        HashMap<Integer,Integer> cnt = new HashMap<>();
        return cnt(nums,target,cnt);
    }
}
