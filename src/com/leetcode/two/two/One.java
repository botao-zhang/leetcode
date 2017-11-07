package com.leetcode.two.two;

public class One {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] area = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for(int i = matrix.length - 1;i>=0;i--){
            for(int j = matrix[0].length - 1;j>=0;j--){
                if(matrix[i][j] == '1'){
                    int min = Math.min(Math.min(area[i+1][j],area[i][j+1]),area[i + 1][j + 1]);
                    area[i][j] = min + 1;
                    max = Math.max(max,area[i][j]);
                }
            }
        }
        return max * max;
    }
}
