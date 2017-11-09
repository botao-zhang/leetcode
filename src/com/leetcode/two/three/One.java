package com.leetcode.two.three;

public class One {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)return false;
        boolean hasOne = false;
        int mask = 1;
        for(int i = 0;i<31;i++){
            if((mask & n) != 0){
                if(hasOne) return false;
                hasOne = true;
            }
            mask = mask << 1;
        }
        return true;
    }
}
