package com.leetcode.zero.zero;

public class Nine {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int tmp = x,digits = 0;
        while (tmp != 0){
            tmp = tmp / 10;
            digits++;
        }

        while (digits > 1){
            int mask = (int) Math.pow(10,digits-1);
            int least = x % 10,most = x / mask;
            if(least != most) return false;
            x -= x / mask * mask;
            x /= 10;
            digits-=2;
        }
        return true;
    }
}
