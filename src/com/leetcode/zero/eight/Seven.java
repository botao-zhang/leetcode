package com.leetcode.zero.eight;

public class Seven {
    private boolean isPossible(String s1, int from1, int to1, String s2, int from2, int to2){
        if(from1 > to1) return true;
        if(from1 == to1) return s1.charAt(from1) == s2.charAt(from2);

        int[] cnt = new int[256];
        int diff = 0;
        for(int i = from1;i<to1;i++){
            cnt[s1.charAt(i)]++;
            if(cnt[s1.charAt(i)] == 0) diff--;
            else if(cnt[s1.charAt(i)] == 1) diff++;
            cnt[s2.charAt(i + from2 - from1)]--;
            if(cnt[s2.charAt(i + from2 - from1)] == 0) diff--;
            else if(cnt[s2.charAt(i + from2 - from1)]  == -1) diff++;

            if(diff == 0){
                if(isPossible(s1,from1,i,s2,from2,from2 + i - from1) &&
                        isPossible(s1,i+1,to1,s2,from2 + i - from1 + 1,to2))return true;
            }
        }

        cnt = new int[256];
        diff = 0;
        for(int i = from1;i<to1;i++){
            int dis = i - from1;
            cnt[s1.charAt(i)]++;
            if(cnt[s1.charAt(i)] == 0) diff--;
            else if(cnt[s1.charAt(i)] == 1) diff++;
            cnt[s2.charAt(to2 - dis)]--;
            if(cnt[s2.charAt(to2 - dis)] == 0) diff--;
            else if(cnt[s2.charAt(to2 - dis)]  == -1) diff++;

            if(diff == 0){
                if(isPossible(s1,from1,i,s2,to2 - dis,to2) &&
                        isPossible(s1,i + 1,to1,s2,from2,to2 - dis - 1))return true;
            }
        }
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        return isPossible(s1,0,s1.length() - 1,s2,0,s2.length() - 1);
    }
}
