package com.leetcode.three.eight;

public class Seven {
    public int firstUniqChar(String s) {
        boolean[] occur = new boolean[256];
        boolean[] rep = new boolean[256];

        for(char c : s.toCharArray()){
            if(occur[c]) rep[c] = true;
            else occur[c] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            if(!rep[s.charAt(i)]) return i;
        }
        return -1;
    }
}
