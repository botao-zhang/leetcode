package com.leetcode.zero.five;

public class Eight {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' ') return len;
            len++;
        }
        return len;
    }
}
