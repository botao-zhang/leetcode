package com.leetcode.two.zero;

import java.util.HashSet;

public class Two {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1){
            if(!set.add(n)) return false;
            int next = 0;
            while (n != 0){
                next += n % 10 * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return true;
    }
}
