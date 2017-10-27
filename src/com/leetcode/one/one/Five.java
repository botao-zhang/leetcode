package com.leetcode.one.one;

import java.util.Arrays;

public class Five {
    public int numDistinct(String s, String t) {
        int[][] cnt = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(cnt[t.length()],1);

        for(int i = t.length() - 1;i>=0;i--){
            for(int j = s.length() - 1;j>=0;j--){
                cnt[i][j] = cnt[i][j+1];
                if(t.charAt(i) == s.charAt(j)) cnt[i][j] += cnt[i + 1][j + 1];
            }
        }

        return cnt[0][0];
    }
}
