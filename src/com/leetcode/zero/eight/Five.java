package com.leetcode.zero.eight;

import java.util.Stack;

public class Five {
    private int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int max = 0;
        for(int i = 0;i<heights.length;i++){
            int left = i;
            while (!s.isEmpty() && heights[i] < s.peek()[1]){
                int[] prev = s.pop();
                max = Math.max(max,prev[1] * (i - prev[0]));
                left = prev[0];
            }

            if(s.isEmpty() || heights[i] > s.peek()[1]) s.push(new int[]{left,heights[i]});
        }

        while (!s.isEmpty()){
            int[] prev = s.pop();
            max = Math.max(max,prev[1] * (heights.length - prev[0]));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix){
        if(matrix.length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            max = Math.max(max,largestRectangleArea(height));
        }
        return max;
    }
}
