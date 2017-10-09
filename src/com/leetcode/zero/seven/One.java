package com.leetcode.zero.seven;

import java.util.Stack;

public class One {
    public String simplifyPath(String path) {
        String[] pathStr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str : pathStr){
            if(str.equals(".")){
                continue;
            }else if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(!str.isEmpty()){
                stack.push(str);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.pop());
            stringBuilder.insert(0,'/');
        }
        if(stringBuilder.length() == 0) return "/";
        return stringBuilder.toString();
    }
}
