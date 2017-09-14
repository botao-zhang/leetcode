package com.leetcode.zero.zero;

public class Five {
    public String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        String candidate = "";

        for(int i = s.length() - 1;i>=0;i--){
            isPalindrome[i][i] = true;
            int lastJ = i;
            for(int j = i + 1;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    isPalindrome[i][j] = j == i + 1 || isPalindrome[i+1][j - 1];
                    if(isPalindrome[i][j]) lastJ = j;
                }
            }
            if(lastJ - i + 1 > candidate.length()) candidate = s.substring(i,lastJ + 1);
        }
        return candidate;
    }
}
