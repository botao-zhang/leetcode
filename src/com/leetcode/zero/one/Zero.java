package com.leetcode.zero.one;

public class Zero {
    boolean canMatch(char s,char p){
        return p == '.' || s == p;
    }
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;

        for(int i = 0;i<p.length();i++){
            if(p.charAt(i) == '*') match[0][i + 1] = match[0][i - 1];
            for(int j = 0;j<s.length();j++){
                if(p.charAt(i) != '*') match[j + 1][i + 1] = match[j][i] && canMatch(s.charAt(j),p.charAt(i));
                else{
                    match[j + 1][i + 1] = match[j + 1][i - 1];
                    match[j + 1][i + 1] |= match[j][i + 1] && canMatch(s.charAt(j),p.charAt(i - 1));
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
