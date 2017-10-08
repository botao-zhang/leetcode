package com.leetcode.zero.five;

public class Nine {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int up = 0,down = n-1,left = 0,right = n - 1,num = 1;

        while (num <= n * n){
            for(int i = left;i<=right;i++) ret[up][i] = num++;
            up++;

            for(int i = up;i<=down;i++) ret[i][right] = num++;
            right--;

            if(up > down || left > right) break;
            for(int i = right;i>=left;i--) ret[down][i] = num++;
            down--;

            for(int i = down;i>=up;i--) ret[i][left] = num++;
            left++;
        }
        return ret;
    }
}
