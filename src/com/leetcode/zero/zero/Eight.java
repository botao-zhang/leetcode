package com.leetcode.zero.zero;

public class Eight {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()) return 0;
        int start = 0, multi = 1;
        if(str.charAt(0) == '+' || str.charAt(0) == '-'){
            start++;
            multi = str.charAt(0) == '-' ? -1 : 1;
        }

        long val = 0;
        for(int i = start;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i))) break;
            val = val * 10 + str.charAt(i) - '0';
            if(val * multi > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(val * multi < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) (val * multi);
    }
}
