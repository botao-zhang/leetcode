package com.leetcode.two.nine;

public class Nine {
    public String getHint(String secret, String guess) {
        int b = 0,c = 0;
        int[] ss = new int[10];
        for(int i = 0;i<secret.length();i++){
            if(i == guess.length()) break;
            if(secret.charAt(i) == guess.charAt(i)) b++;
            ss[secret.charAt(i) - '0']++;
        }

        for(int i = 0;i<guess.length();i++){
            int idx = guess.charAt(i) - '0';
            if(ss[idx] > 0){
                c++;
                ss[idx]--;
            }
        }

        return b + "A" + (c - b) + "B";
    }
}
