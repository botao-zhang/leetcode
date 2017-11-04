package com.leetcode.one.eight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Seven {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(s.substring(0,10));

        HashSet<String> set = new HashSet<>(), dup = new HashSet<>();
        set.add(stringBuilder.toString());
        for(int i = 10;i<s.length();i++){
            stringBuilder.append(s.charAt(i));
            stringBuilder.deleteCharAt(0);
            if(!set.add(stringBuilder.toString())) dup.add(stringBuilder.toString());
        }
        return new ArrayList<>(dup);
    }
}
