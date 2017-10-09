package com.leetcode.zero.six;

import java.util.List;

public class Six {
    public int[] plusOne(int[] digits) {
        boolean all9 = true;
        for(int d : digits) if(d != 9){
            all9 = false;
            break;
        }

        int[] ret = new int[digits.length + (all9 ? 1 : 0)];
        int plus = 1;
        for(int i = digits.length - 1;i>=0;i--){
            ret[i] = digits[i] + plus;
            if(ret[i] == 10){
                ret[i] = 0;
                plus = 1;
            }else{
                plus = 0;
            }
        }

        if(all9) ret[0] = 1;
        return ret;
    }
}
