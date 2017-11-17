package com.leetcode.three.two;

import java.util.Arrays;

public class Nine {
    int max = 0;
    int[][] cache;

    private static int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

    private int help(int[][] matrix,int i,int j){
        if(cache[i][j] >= 0) return cache[i][j];

        int localMax = 0;
        for(int[] dir : dirs){
            int x = i + dir[0],y = j + dir[1];
            if(x >= 0 && x < matrix.length && y >=0 && y < matrix[0].length){
                if(matrix[i][j] < matrix[x][y]) localMax = Math.max(localMax,1 + help(matrix,x,y));
            }
        }

        max = Math.max(max,localMax);
        cache[i][j] = localMax;
        return localMax;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        cache = new int[matrix.length][matrix[0].length];
        for(int[] line : cache) Arrays.fill(line,-1);

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                help(matrix,i,j);
            }
        }

        for(int[] line : cache) System.out.println(Arrays.toString(line));

        return max + 1;
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
