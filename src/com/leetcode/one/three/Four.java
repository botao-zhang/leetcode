package com.leetcode.one.three;

public class Four {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0;i<gas.length;i++){
            int left = 0;
            for(int j = 0;j<gas.length;j++){
                int pos = (i + j) % gas.length;
                left += gas[pos] - cost[pos];
                if(left < 0) break;
            }
            if(left >= 0) return i;
        }
        return -1;
    }
}
