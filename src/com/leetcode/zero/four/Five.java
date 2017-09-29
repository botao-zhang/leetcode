package com.leetcode.zero.four;

public class Five {
    public int jump(int[] nums){
        if(nums.length == 0) return 0;
        int cnt = 0;
        int start = 0,reach = 0;
        while (reach < nums.length - 1){
            int curReach = 0;
            cnt++;
            for(int i = start;i <= reach;i++){
                curReach = Math.max(i + nums[i],curReach);
            }
            start = reach + 1;
            reach = curReach;
        }
        return cnt;
    }
}
