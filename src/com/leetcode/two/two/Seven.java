package com.leetcode.two.two;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Seven {
    private void addNum(int num,Deque<Character> ops,Deque<Integer> oprands){
        if(ops.isEmpty() || ops.getLast() == '+' || ops.getLast() == '-') oprands.addLast(num);
        else{
            int first = oprands.removeLast();
            char op = ops.removeLast();
            if(op == '*') oprands.addLast(first * num);
            else oprands.addLast(first / num);
        }
    }

    public int calculate(String s) {
        Deque<Character> ops = new LinkedList<>();
        Deque<Integer> oprands = new LinkedList<>();

        int num = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                addNum(num,ops,oprands);
                num = 0;
                ops.addLast(c);
            }
        }
        addNum(num,ops,oprands);

        int first = oprands.removeFirst();
        while (!oprands.isEmpty()){
            int second = oprands.removeFirst();
            char op = ops.removeFirst();
            if(op == '+') first += second;
            else first -= second;
        }
        return first;
    }
}
