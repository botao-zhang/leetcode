package com.leetcode.two.two;

import java.util.ArrayList;
import java.util.List;

public class Eight {
    public List<String> summaryRanges(int[] nums) {
        int rangeStart = -1;
        List<String> ret = new ArrayList<>();
        for(int i = 1;i<=nums.length;i++){
            if(rangeStart >= 0){
                if(i == nums.length || i - rangeStart != nums[i] - nums[rangeStart]){
                    ret.add(nums[rangeStart] + "->" + nums[i - 1]);
                    rangeStart = -1;
                }
            }else{
                if(i < nums.length && nums[i] - nums[i - 1] == 1){
                    rangeStart = i - 1;
                }else{
                    ret.add(new Integer(nums[i - 1]).toString());
                }
            }
        }

        return ret;
    }
}
