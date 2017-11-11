package com.leetcode.two.nine;

import java.util.HashMap;
import java.util.HashSet;

public class Zero {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;

        String[] p2w = new String[26];
        HashMap<String,Character> set = new HashMap<>();

        for(int i = 0;i<pattern.length();i++){
            String mapped = p2w[pattern.charAt(i) - 'a'];
            if(mapped != null && !mapped.equals(words[i])) return false;
            p2w[pattern.charAt(i) - 'a'] = words[i];
            Character c = set.get(words[i]);
            if(c != null && c != pattern.charAt(i)) return false;
            set.put(words[i],pattern.charAt(i));
        }

        return true;

    }
}
