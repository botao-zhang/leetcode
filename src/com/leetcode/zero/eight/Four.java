package com.leetcode.zero.eight;

import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.MARSHAL;

import java.util.Stack;

public class Four {
    public int largestRectangleArea(int[] heights) {
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
}
