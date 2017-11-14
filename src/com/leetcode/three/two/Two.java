package com.leetcode.three.two;

import java.util.Arrays;
import java.util.HashMap;

public class Two {
    HashMap<Integer,Integer> cache = new HashMap<>();
    int minCnt(int[] coins, int amount){
        System.out.println("amount = " + amount);
        if(amount == 0) return 0;
        if(cache.containsKey(amount)) return cache.get(amount);
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<coins.length;i++){
            if(amount < coins[i]) break;
            int next = minCnt(coins,amount - coins[i]);
            if(next >= 0) min = Math.min(min,next + 1);
        }

        if(min < Integer.MAX_VALUE){
            cache.put(amount,min);
        }else{
            cache.put(amount,-1);
        }
        return cache.get(amount);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return minCnt(coins,amount);
    }

    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two.coinChange(new int[]{1},1));
    }
}
