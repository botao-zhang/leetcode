package com.leetcode.zero.three;

public class Eight {
    public String countAndSay(int n) {
        if(n < 1) return "";
        StringBuilder now = new StringBuilder("1");
        int iter = 1;

        while (iter++ < n){
            StringBuilder next = new StringBuilder();
            int cnt = 1;
            char c = now.charAt(0);
            for(int i = 1;i<now.length();i++){
                if(now.charAt(i) == c) cnt++;
                else{
                    next.append(cnt);
                    next.append(c);
                    cnt = 1;
                    c = now.charAt(i);
                }
            }
            next.append(cnt);
            next.append(c);
            now = next;
        }
        return now.toString();
    }
}
