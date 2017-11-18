package com.leetcode.three.three;

import java.util.Arrays;

public class Eight {
    public int[] countBits(int num) {
        int limit = 1;
        int[] ret = new int[num +1];
        for(int i = 1;i<=num;i++){
            if(i == limit){
                limit = limit << 1;
                ret[i] = 1;
            }else{
                ret[i] = ret[i - limit / 2] + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(Arrays.toString(eight.countBits(5)));
    }
}
