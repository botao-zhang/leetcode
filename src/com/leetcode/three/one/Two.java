package com.leetcode.three.one;

import java.util.Arrays;
import java.util.HashMap;

public class Two {
    HashMap<String,Integer> cache = new HashMap<>();
    int burst(int[] iNums, int from, int to, int left, int right){
        if(from > to) return 0;

        StringBuilder key = new StringBuilder();
        key.append(from);
        key.append('#');
        key.append(to);

        if(cache.get(key.toString()) != null) return cache.get(key.toString());
        int max = 0;
        for(int i = from;i<=to;i++){
                max = Math.max(max, iNums[i] * left * right + burst(iNums, from, i - 1, left, iNums[i]) +
                        burst(iNums, i + 1, to, iNums[i], right));
        }
        cache.put(key.toString(),max);
        return max;
    }

    public int maxCoins(int[] iNums){
        return burst(iNums,0,iNums.length - 1,1,1);
    }

}
