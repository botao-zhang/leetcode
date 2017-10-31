package com.leetcode.one.three;

public class Seven {
    public int singleNumber(int[] nums) {
        int[] cnts = new int[32];
        for(int num : nums){
            for(int j = 0;j<32;j++){
                int mask = 1 << j;
                if((num & mask) != 0) cnts[j]++;
            }
        }

        int ret = 0;
        for(int i = 0;i<32;i++){
            if(cnts[i] % 3 != 0){
                ret |= 1 << i;
            }
        }
        return ret;
    }
}
