package com.leetcode.zero.six;

import java.util.Arrays;

public class Four {
    public int minPathSum(int[][] grid) {
        int[][] sum = new int[grid.length][grid[0].length];

        for(int i = grid.length - 1;i>=0;i--){
            for(int j = grid[0].length - 1;j>=0;j--){
                if(i == grid.length - 1&& j == grid[0].length - 1) sum[i][j] = grid[i][j];
                else{
                    if(i == grid.length - 1) sum[i][j] = grid[i][j] + sum[i][j + 1];
                    else if(j == grid[0].length - 1) sum[i][j] = grid[i][j] + sum[i + 1][j];
                    else sum[i][j] = grid[i][j] + Math.min(sum[i + 1][j],sum[i][j + 1]);
                }
            }
        }
        for(int[] s : sum) System.out.println(Arrays.toString(s));
        return sum[0][0];
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.minPathSum(new int[][]{{1,2},{1,1}}));
    }
}
