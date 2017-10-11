package com.leetcode.zero.seven;

public class Three {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        boolean firstCol0 = false;

        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j != 0) matrix[0][j] = 0;
                    else firstCol0 = true;
                }
            }
        }

        for(int i = matrix.length - 1;i>0;i--){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0) for(int i = 0;i<matrix[0].length;i++) matrix[0][i] = 0;
        if(firstCol0) for(int i = 0;i<matrix.length;i++) matrix[i][0] = 0;

    }
}
