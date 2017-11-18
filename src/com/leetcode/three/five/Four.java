package com.leetcode.three.five;

import java.util.Arrays;
import java.util.Comparator;

public class Four {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] cnt = new int[envelopes.length];
        for(int i = envelopes.length - 2;i>=0;i--){
            int max = 0;
            for(int j = i + 1;j<envelopes.length;j++){
                if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) max = Math.max(max,cnt[j] + 1);
            }
            cnt[i] = max;
        }

        int max = 0;
        for(int c : cnt) max = Math.max(max,c);
        return max + 1;
    }
}
