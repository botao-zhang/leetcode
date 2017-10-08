package com.leetcode.zero.six;

public class Three {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] ways = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        ways[ways.length - 1][ways[0].length - 1] = 1;

        for(int i = ways.length - 1;i>=0;i--){
            for(int j = ways[0].length - 1;j>=0;j--){
                if(obstacleGrid[i][j] == 0) {
                    if (i + 1 < ways.length && obstacleGrid[i + 1][j] == 0) {
                        ways[i][j] += ways[i + 1][j];
                    }

                    if (j + 1 < ways[0].length && obstacleGrid[i][j + 1] == 0) {
                        ways[i][j] += ways[i][j + 1];
                    }
                }
            }
        }

        return ways[0][0];
    }
}
