package com.leetcode.one.three;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Five {
    public int candy(int[] ratings){
        int[] left = new int[ratings.length],right = new int[ratings.length];
        for(int i = 1;i<ratings.length;i++){
            if(ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }

        for(int i = ratings.length - 2;i>=0;i--){
            if(ratings[i] > ratings[i + 1]) right[i] = right[i + 1] + 1;
        }

        int sum = ratings.length;
        for(int i = 0;i<ratings.length;i++){
            sum += Math.max(left[i],right[i]);
        }
        return sum;
    }
}
