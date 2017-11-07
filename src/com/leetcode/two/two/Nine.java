package com.leetcode.two.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nine {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length < 2){
            for(int num : nums) ret.add(num);
            return ret;
        }

        int first = nums[0],firstT = 1;
        int second = -1,secondT = - 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == first) firstT++;
            else if(secondT > 0){
                if(second == nums[i]){
                    secondT++;
                    if(secondT > firstT){
                        int tmp = first;
                        first = second;
                        second = tmp;
                        tmp = firstT;
                        firstT = secondT;
                        secondT = tmp;
                    }
                }else{
                    firstT--;
                    secondT--;
                    if(firstT == 0){
                        first = nums[i];
                        firstT = 1;
                    }else if(secondT == 0){
                        second = nums[i];
                        secondT = 1;
                    }
                }
            }else{
                secondT = 1;
                second = nums[i];
            }
        }

        if(firstT > 0){
            int times = 0;
            for(int i = 0;i<nums.length;i++) if(nums[i] == first) times++;
            if(times > nums.length / 3) ret.add(first);
        }

        if(secondT > 0){
            int times = 0;
            for(int i = 0;i<nums.length;i++) if(nums[i] == second) times++;
            if(times > nums.length / 3) ret.add(second);
        }
        return ret;
    }
}
