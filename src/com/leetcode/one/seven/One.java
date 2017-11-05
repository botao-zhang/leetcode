package com.leetcode.one.seven;

public class One {
    public int titleToNumber(String s) {
        int sum = 0;
        for(char c : s.toCharArray()){
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
