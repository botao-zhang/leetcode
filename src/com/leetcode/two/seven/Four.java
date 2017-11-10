package com.leetcode.two.seven;

import java.util.Arrays;

public class Four {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for(int i = 0;i<citations.length;i++){
            int higher = citations.length - i;
            if(citations[i] >= higher) return higher;
        }
        return 0;
    }
}
