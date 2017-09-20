package com.leetcode.zero.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eight {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int want = target - nums[i];
            for(int j = i + 1;j<nums.length;j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1,h = nums.length - 1;
                while (l < h){
                    if(l > j + 1 && nums[l] == nums[l - 1]){
                        l++;
                        continue;
                    }
                    if(h < nums.length - 1 && nums[h] == nums[h + 1]){
                        h--;
                        continue;
                    }
                    int sum = nums[j] + nums[l] + nums[h];
                    if(sum == want) ret.add(Arrays.asList(nums[i],nums[j],nums[l],nums[h]));
                    if(sum > want) h--;
                    else l++;
                }
            }
        }
        return ret;
    }
}
