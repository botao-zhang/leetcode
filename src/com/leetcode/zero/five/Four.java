package com.leetcode.zero.five;

import java.util.ArrayList;
import java.util.List;

public class Four {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if(matrix.length == 0) return ret;

        int up = 0,down = matrix.length - 1,left = 0,right = matrix[0].length - 1;
        while (up <= down && left <= right){
            for(int i = left;i<=right;i++) ret.add(matrix[up][i]);
            up++;

            for(int i = up;i<=down;i++) ret.add(matrix[i][right]);
            right--;

            if(up > down || left > right) break;
            for(int i = right;i>=left;i--) ret.add(matrix[down][i]);
            down--;

            for(int i = down;i>=up;i--) ret.add(matrix[i][left]);
            left++;
        }
        return ret;
    }
}
