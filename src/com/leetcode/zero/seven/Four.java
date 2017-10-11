package com.leetcode.zero.seven;

public class Four {


    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end){
            int mid = (start + end) / 2, r = mid / matrix[0].length, c = mid % matrix[0].length;
            if(matrix[r][c] == target) return true;
            if(matrix[r][c] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
