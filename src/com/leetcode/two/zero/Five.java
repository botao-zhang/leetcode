package com.leetcode.two.zero;

import java.util.HashMap;
import java.util.HashSet;

public class Five {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        boolean[] occur = new boolean[256];
        if(s.length() != t.length()) return false;
        for(int i = 0;i<s.length();i++){
            char sc = s.charAt(i),tc = t.charAt(i);
            Character mapped = map.get(sc);
            if(mapped == null){
                if(occur[tc]) return false;
                map.put(sc,tc);
            }
            else if(tc != mapped) return false;
            occur[tc] = true;
        }
        return true;
    }
}
