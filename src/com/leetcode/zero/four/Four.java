package com.leetcode.zero.four;

public class Four {
    public boolean isMatch(String s, String p){
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;

        for(int i = 0;i<p.length();i++){
            match[0][i+1] = p.charAt(i) == '*' && match[0][i];
            for(int j = 0;j<s.length();j++){
                if(p.charAt(i) != '*'){
                    match[j + 1][i + 1] = match[j][i] && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j));
                }else{
                    match[j + 1][i + 1] = match[j][i] || match[j + 1][i] || match[j][i+1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
