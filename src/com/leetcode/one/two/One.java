package com.leetcode.one.two;

public class One {
    public int maxProfit(int[] prices) {
        int pro = 0, min = Integer.MAX_VALUE;
        for(int i = 0;i<prices.length;i++){
            if(prices[i] > min) pro = Math.max(pro,prices[i] - min);
            else min = prices[i];
        }

        return pro;

    }
}
