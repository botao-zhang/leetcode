package com.leetcode.zero.seven;

import java.util.Arrays;

public class Two {
    public int minDistance(String word1, String word2){
        int[][] dis = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0;i<word2.length();i++) dis[word1.length()][i] = word2.length() - i;
        for(int i = 0;i<word1.length();i++) dis[i][word2.length()] = word1.length() - i;

        for(int i = word1.length() - 1;i>=0;i--){
            for(int j = word2.length() - 1;j>=0;j--){
                dis[i][j] = (word1.charAt(i) == word2.charAt(j) ? 0 : 1) + dis[i + 1][j + 1];
                dis[i][j] = Math.min(dis[i][j],1 + dis[i][j + 1]);
                dis[i][j] = Math.min(dis[i][j],1 + dis[i + 1][j]);
            }
        }

        return dis[0][0];
    }
}
