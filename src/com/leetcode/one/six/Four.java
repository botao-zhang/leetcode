package com.leetcode.one.six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Four {
    public int maximumGap(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        List<Integer> list = new ArrayList<>(set);

        if(list.size() < 2) return 0;

        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        for(int num : list){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        int totals = max - min, segs = list.size() - 1, numsInSeg = totals / segs;

        int[] segsMin = new int[totals / numsInSeg + 1],segsMax = new int[totals / numsInSeg + 1];
        Arrays.fill(segsMax,Integer.MIN_VALUE);
        Arrays.fill(segsMin,Integer.MAX_VALUE);

        for(int num : list){
            int segIdx = (num - min) / numsInSeg;

            segsMax[segIdx] = Math.max(segsMax[segIdx],num);
            segsMin[segIdx] = Math.min(segsMin[segIdx],num);
        }

        int prev = segsMax[0],gap = 0;
        for(int i = 1;i<segsMin.length;i++){
            if(segsMin[i] <= segsMax[i]){
                gap = Math.max(gap,segsMin[i] - prev);
                prev = segsMax[i];
            }
        }
        return gap;
    }

}
