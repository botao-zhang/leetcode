package com.leetcode.one.seven;

public class Two {
    public int trailingZeroes(int n) {
        long power = 0,k = 1;
        while (k <= n){
            k *= 5;
            power++;
        }

        int total = 0;
        while (power > 0){
            total += n / k;
            power--;
            k /= 5;
        }

        return total;
    }
}
