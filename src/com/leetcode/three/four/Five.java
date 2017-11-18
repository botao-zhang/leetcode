package com.leetcode.three.four;

import java.util.ArrayList;
import java.util.List;

public class Five {
    public String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        List<Character> chars = new ArrayList<>();
        List<Integer> poses = new ArrayList<>();

        for(int i = 0;i<s.length();i++){
            char lowc = Character.toLowerCase(s.charAt(i));
            if(lowc == 'a' || lowc == 'e' || lowc == 'i' || lowc == 'o' || lowc == 'u'){
                chars.add(s.charAt(i));
                poses.add(i);
            }
        }

        for(int i = chars.size() - 1;i>=0;i--){
            int pos = poses.get(chars.size() - i - 1);
            stringBuilder.setCharAt(pos,chars.get(i));
        }
        return stringBuilder.toString();
    }
}
