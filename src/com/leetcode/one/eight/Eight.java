package com.leetcode.one.eight;

import java.util.Arrays;

public class Eight {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) return quickSolve(prices);

        int[] buys = new int[k + 1],sells = new int[k + 1];
        Arrays.fill(buys,Integer.MIN_VALUE);
        for(int i = 0;i<prices.length;i++){
            for(int j = k - 1;j>=0;j--){
                sells[j + 1] = Math.max(sells[j + 1],buys[j + 1] + prices[i]);
                buys[j + 1] = Math.max(buys[j + 1],sells[j] - prices[i]);
            }
        }

        //System.out.println("buys = " + Arrays.toString(buys) + " sells = " + Arrays.toString(sells));

        return sells[k];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

}
