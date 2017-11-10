package com.leetcode.two.six;

public class Zero {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) xor ^= num;

        int mask = 1;
        for(int i = 0;i<31;i++){
            if((xor & mask) != 0) break;
            mask <<= 1;
        }

        int first = 0,second = 0;
        for(int num : nums){
            if((num & mask) != 0) first ^= num;
            else second ^= num;
        }
        return new int[]{first,second};
    }
}
