package com.leetcode.one.seven;

import java.util.LinkedList;
import java.util.Queue;

public class Four {
    public int calculateMinimumHP(int[][] dungeon){
        if(dungeon.length == 0) return 0;
        int[][] powers = new int[dungeon.length][dungeon[0].length];

        powers[dungeon.length - 1][dungeon[0].length - 1] = Math.max(1 - dungeon[dungeon.length - 1][dungeon[0].length - 1],1);

        for(int i = dungeon[0].length - 2;i>=0;i--) powers[dungeon.length - 1][i] = Math.max(powers[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i],1);
        for(int i = dungeon.length - 2;i>=0;i--)    powers[i][dungeon[0].length - 1] = Math.max(powers[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1],1);

        for(int i = dungeon.length - 2;i>=0;i--){
            for(int j = dungeon[0].length - 2;j>=0;j--){
                int minRequired = Math.min(powers[i+1][j],powers[i][j+1]);
                powers[i][j] = Math.max(minRequired - dungeon[i][j],1);
            }
        }
        return powers[0][0];
    }
}
