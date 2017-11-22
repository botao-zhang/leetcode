package com.leetcode.three.seven;

import java.util.Arrays;

public class Five {
    private int guess(int from,int to,int[][] cache){
        if(from >= to) return 0;
        if(cache[from][to] > 0) return cache[from][to];

        int money = Integer.MAX_VALUE;

        for(int i = from;i<=to;i++){
            int cost = i + Math.max(guess(from,i-1,cache),guess(i + 1,to,cache));
            money = Math.min(money,cost);
        }

        cache[from][to] = money;
        return money;
    }

    public int getMoneyAmount(int n) {
        int[][] cache = new int[n+1][n+1];

        return guess(1,n,cache);
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.getMoneyAmount(5));
    }
}
