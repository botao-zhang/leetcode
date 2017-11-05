package com.leetcode.two.zero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four {
    public int countPrimes(int n) {
        boolean[] isP = new boolean[n];
        Arrays.fill(isP,true);

        int k = 0;
        for(int i = 2;i<n;i++){
            if(isP[i]){
                k++;
                for(int j = 2;j * i < n;j++) isP[j * i] = false;
            }

        }
        return k;
    }
}
