package com.leetcode.three.six;

import java.util.Arrays;
import java.util.TreeSet;

public class Three {
    public int maxSumSubmatrix(int[][] matrix, int k){
        if(matrix.length == 0) return 0;
        int[][] sums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                sums[i + 1][j + 1] += sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
            }
        }

        for(int[] sum : sums) System.out.println(Arrays.toString(sum));
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<matrix[0].length;i++){
            for(int j = i + 1;j<=matrix[0].length;j++){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                for(int m = 1;m<=matrix.length;m++){
                    int now = sums[m][j] - sums[m][i];
                    Integer n = set.higher(now - k - 1);
                    System.out.println("now = " + now + " j = " + j + " i = " + i + " m = " + m + " set = " + set + " n = " + n);

                    if(n != null) max = Math.max(max,now - n);
                    set.add(now);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.maxSumSubmatrix(new int[][]{{1,  0, 1},{0, -2, 3}},2));
        System.out.println(three.maxSumSubmatrix(new int[][]{{2,2,-1}},3));
        System.out.println(three.maxSumSubmatrix(new int[][]{{2,2,-1}},0));
    }
}
