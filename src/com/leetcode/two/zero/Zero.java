package com.leetcode.two.zero;

import java.util.LinkedList;
import java.util.Queue;

public class Zero {
    private static int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(char[][] grid,int i, int j){
        if(i >= 0 && i<grid.length && j >= 0 && j< grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            for(int[] dir : dirs){
                dfs(grid,i + dir[0],j+dir[1]);
            }
        }

    }
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }
}
