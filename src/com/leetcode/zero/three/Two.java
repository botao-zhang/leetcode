package com.leetcode.zero.three;

import java.util.Arrays;
import java.util.Stack;

public class Two {

    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }

        int last = s.length(),max = 0;
        while (!stack.isEmpty()){
            int next = stack.pop();
            max = Math.max(last - next - 1,max);
            last = next;
        }
        return Math.max(max,last);
    }
}
