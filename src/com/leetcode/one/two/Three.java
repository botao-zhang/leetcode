package com.leetcode.one.two;

import java.net.Inet4Address;

public class Three {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE,sell1 = 0,buy2 = Integer.MIN_VALUE,sell2 = 0;

        for(int i = 0;i<prices.length;i++){
            sell2 = Math.max(sell2,prices[i] + buy2);
            buy2 = Math.max(buy2,sell1 - prices[i]);
            sell1 = Math.max(sell1,prices[i] + buy1);
            buy1 = Math.max(buy1,-1 * prices[i]);
            //System.out.println("p = " + prices[i] + " buy1 = " + buy1 + "sell1 = " + sell1 + " buy2 = " + buy2 + " sell2 = " +sell2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.maxProfit(new int[]{1,1,1,2,1,4,0,5}));
    }
}
