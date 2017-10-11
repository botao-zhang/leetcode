package com.leetcode.zero.seven;

import java.util.Arrays;

public class Six {
    public String minWindow(String s, String t) {
        int[] needed = new int[256];
        int left = t.length();
        for(char c : t.toCharArray()) needed[c]++;

        int fast = 0,slow = 0;
        String can = "";
        while (fast < s.length()) {
            if(--needed[s.charAt(fast++)] >= 0) left--;
            if(left == 0){
                while (slow < fast){
                    if(++needed[s.charAt(slow++)] > 0){
                        left++;
                        if(can.length() == 0 || can.length() > fast - slow + 1) can = s.substring(slow - 1,fast);
                        break;
                    }
                }
            }
        }
        return can;
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.minWindow("ADOBECODEBANC","ABC"));
    }
}
