package com.leetcode.zero.four;

public class One {
    public int firstMissingPositive(int[] nums){
        for(int i = 0;i<nums.length;i++){
            int supposedIdx = nums[i] - 1;
            if(supposedIdx == i || supposedIdx < 0 || supposedIdx >= nums.length) continue;

            int tmp = nums[supposedIdx];
            if(tmp == nums[i]) continue;

            nums[supposedIdx] = nums[i];
            nums[i] = tmp;
            i--;
        }

        for(int i = 0;i<nums.length;i++) if(nums[i] != i+1) return i+1;
        return nums.length + 1;
    }
}
