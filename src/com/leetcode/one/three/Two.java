package com.leetcode.one.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Two {


    public int minCut(String s) {
        boolean[][] isPali = new boolean[s.length()][s.length()];
        int[] cuts = new int[s.length() + 1];

        for(int i = s.length() - 1;i>=0;i--){
            isPali[i][i] = true;
            cuts[i] = cuts[i + 1] + 1;
            for(int j = i + 1;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    isPali[i][j] = j == i + 1 || isPali[i + 1][j - 1];
                    if(isPali[i][j]) cuts[i] = Math.min(cuts[i], 1 + cuts[j + 1]);
                }
            }
        }

        return cuts[0] - 1;
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.minCut("aab"));
        System.out.println(two.minCut("a"));

    }
}
