package com.leetcode.two.seven;

public class Five {
    public int hIndex(int[] citations) {
        for(int i = 0;i<citations.length;i++){
            int higher = citations.length - i;
            if(citations[i] >= higher) return higher;
        }
        return 0;
    }
}
