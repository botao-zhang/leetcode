package com.leetcode.three.eight;

import java.util.Stack;

public class Eight {

    public int lengthLongestPath(String input) {
        if(input.length() == 0) return 0;
        String[] segs = input.split("\n");

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{-1,-1});
        int max = 0;
        for(int i = 0;i<segs.length;i++){
            int level = 0;
            for(int j = 0;j<segs[i].length();j++){
                if(segs[i].charAt(j) == '\t') level++;
                else break;
            }
            int len = segs[i].length() - level;

            while (stack.peek()[0] >= level){
                stack.pop();
            }

            len += stack.peek()[1] + 1;
            if(segs[i].contains(".")) max = Math.max(len,max);
            stack.push(new int[]{level,len});
        }
        return max;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.lengthLongestPath("dir\n"));
    }
}
