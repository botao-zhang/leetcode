package com.leetcode.one.six;

public class Eight {
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0){
            int reminder = (n - 1) % 26;

            char c = (char) ('A' + reminder);
            stringBuilder.insert(0,c);
            n = (n - 1) / 26;
        }
        return stringBuilder.toString();
    }
}
