package com.leetcode.three.zero;

import java.util.Arrays;

public class Four {
    static class NumMatrix {
        int[][] sums;
        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0) return;
            sums = new int[matrix.length + 1][matrix[0].length + 1];

            for(int i = 0;i<matrix.length;i++){
                for(int j = 0;j<matrix[0].length;j++){
                    sums[i+1][j + 1] = sums[i + 1][j] + matrix[i][j] + sums[i][j + 1] - sums[i][j];
                }
            }

            for(int[] sum : sums) System.out.println(Arrays.toString(sum));
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{1,1,1,1},{2,2,2,2}});
    }
}
