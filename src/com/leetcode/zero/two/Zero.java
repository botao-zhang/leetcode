package com.leetcode.zero.two;

import java.util.Stack;

public class Zero {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                open.push(c);
            }else{
                if(open.isEmpty()) return false;
                char existing = open.pop();
                if(c == ')' && existing != '(') return false;
                if(c == ']' && existing != '[') return false;
                if(c == '}' && existing != '{') return false;
            }
        }
        return open.isEmpty();
    }
}
