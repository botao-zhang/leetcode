package com.leetcode.two.four;

public class Zero {
    private boolean help(int[][] matrix,int rf, int rt, int cf, int ct, int target){
        if(rf > rt || cf > ct) return false;
        int rm = (rf + rt) / 2,cm = (cf + ct) / 2;

        if(matrix[rm][cm] == target) return true;
        if(matrix[rm][cm] > target){
            return help(matrix,rf,rm - 1,cf,ct,target) || help(matrix,rm,rt,cf,cm - 1,target);
        }else{
            return help(matrix,rf,rm,cm + 1,ct,target) || help(matrix,rm + 1,rt,cf,ct,target);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        return help(matrix,0,matrix.length - 1,0,matrix[0].length - 1,target);
    }
}
