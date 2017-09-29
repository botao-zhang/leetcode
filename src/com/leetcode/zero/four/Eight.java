package com.leetcode.zero.four;

public class Eight {
    public void rotate(int[][] matrix) {
        int up = 0,down = matrix.length - 1,left = 0,right = matrix.length - 1;
        while (up < down){
            for(int i = left;i<right;i++){
                int offset = i - left;
                int tmp = matrix[up][i];
                matrix[up][i] = matrix[down - offset][left];
                matrix[down - offset][left] = matrix[down][right - offset];
                matrix[down][right - offset] = matrix[up + offset][right];
                matrix[up + offset][right] = tmp;
            }
            up++;
            down--;
            left++;
            right--;
        }
    }


}
