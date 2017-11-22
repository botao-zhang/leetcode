package com.leetcode.three.eight;

public class Three {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[256];
        for(char c : magazine.toCharArray()){
            cnt[c]++;
        }

        for(char c : ransomNote.toCharArray()){
            cnt[c]--;
            if(cnt[c] < 0) return false;
        }
        return true;
    }
}
