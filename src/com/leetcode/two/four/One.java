package com.leetcode.two.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class One {

    private List<Integer> help(int from, int to,List<Integer> oprands,List<Character> ops){
        if(from == to){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(oprands.get(from));
            return tmp;
        }
        List<Integer> tmp = new ArrayList<>();
        for(int i = from;i<to;i++){
            List<Integer> left = help(from,i,oprands,ops);

            List<Integer> right = help(i+1,to,oprands,ops);
            //System.out.println("from = " + from + " to = " + to + " tmp = " + tmp + " left = " + left + " right = " + right + " i = " + i);

            for(Integer l : left){
                for(Integer r : right){
                    switch (ops.get(i)){
                        case '+':
                            tmp.add(l + r);
                            break;
                        case '-':
                            tmp.add(l - r);
                            break;
                        case '*':
                            tmp.add(l * r);
                            break;
                    }
                }
            }


        }
        //System.out.println("from = " + from + " to = " + to + " tmp = " + tmp);

        return tmp;
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        int num = 0;
        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else{
                nums.add(num);
                num = 0;
                chars.add(c);
            }
        }
        nums.add(num);
        System.out.println("nums = " + nums +" chars = " + chars);
        return help(0,nums.size() - 1,nums,chars);
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.diffWaysToCompute("2-1-1"));
        System.out.println(one.diffWaysToCompute("2*3-4*5"));
    }
}
