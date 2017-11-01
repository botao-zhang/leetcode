package com.leetcode.one.five;

import java.util.Stack;

public class Zero {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ops = new Stack<>();

        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                ops.push(ops.pop() + ops.pop());
            }else if(tokens[i].equals("*")){
                ops.push(ops.pop() * ops.pop());
            }else if(tokens[i].equals("-")){
                int second = ops.pop();
                ops.push(ops.pop() - second);
            }else if(tokens[i].equals("/")){
                int second = ops.pop();
                ops.push(ops.pop() / second);
            }else{
                ops.push(Integer.parseInt(tokens[i]));
            }
        }
        return ops.pop();
    }
}
