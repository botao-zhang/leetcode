package com.leetcode.zero.zero;

import java.util.HashMap;

/**
 * Created by botao on 2017/9/13.
 */
public class One {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            Integer needed = map.get(target - nums[i]);
            if(needed != null) return new int[]{needed,i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
