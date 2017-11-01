package com.leetcode.one.five;

import java.util.Stack;

public class One {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        for(String str : arr) stack.push(str);

        while (!stack.isEmpty()){
            String str = stack.pop();
            if(!str.isEmpty()){
                if(stringBuilder.length() > 0) stringBuilder.append(' ');
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }
}
