package com.leetcode.two.three;


public class Three {
    public int countDigitOne(int n) {
        if(n <= 0) return 0;
        long m = 1,cur = 0;

        while (n >= m){
            cur = cur * 10 + m / 10;
            m *= 10;
        }
        m /= 10;
        return (int) (n / m * cur + Math.min(n - m + 1,m) + countDigitOne((int) (n % m)));
    }
}
