package com.leetcode.three.zero;

import java.util.Arrays;

public class Nine {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] sell = new int[prices.length + 1], buy = new int[prices.length + 1];
        buy[0] = Integer.MIN_VALUE;

        for(int i = 0;i<prices.length;i++){
            sell[i + 1] = Math.max(sell[i],buy[i] + prices[i]);
            if(i > 0) buy[i + 1] = Math.max(buy[i],sell[i - 1] - prices[i]);
            else buy[i + 1] = -1 * prices[i];
        }

        return sell[prices.length];
    }

}
