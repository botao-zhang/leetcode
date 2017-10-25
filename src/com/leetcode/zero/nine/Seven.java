package com.leetcode.zero.nine;

public class Seven {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        boolean[][] can = new boolean[s1.length() + 1][s2.length() + 1];
        can[s1.length()][s2.length()] = true;

        for(int i = 1;i<=s3.length();i++){
            int tid = s3.length() - i;
            for(int first = 0;first <= i;first++){
                int second = i - first, fid = s1.length() - first,sid = s2.length() - second;
                if(fid < 0 || sid < 0) continue;
                if(fid < s1.length() && s1.charAt(fid) == s3.charAt(tid)){
                    can[fid][sid] |= can[fid + 1][sid];
                }

                if(sid < s2.length() && s2.charAt(sid) == s3.charAt(tid)){
                    can[fid][sid] |= can[fid][sid + 1];
                }
            }
        }

        return can[0][0];
    }
}
