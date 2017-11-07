package com.leetcode.two.two;

import java.util.Stack;

public class Four {
    boolean adding = true;
    int total = 0,num = 0;
    Stack<Boolean> add = new Stack<>();

    private void eval(){
        if(adding)total += num;
        else total -= num;
        num = 0;
    }

    public int calculate(String s){
        add.push(true);

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '+'){
                eval();
                adding = add.peek();
            }else if(s.charAt(i) == '-'){
                eval();
                adding = !add.peek();
            }else if(s.charAt(i) == '('){
                add.push(adding);
            }else if(s.charAt(i) == ')'){
                add.pop();
            }else if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) - '0';
            }else{
                eval();
            }
            System.out.println("i = " + i + " c = " + s.charAt(i) + " nu = " + num + " t = " + total);
        }
        eval();
        return total;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.calculate("1 + 1"));
        four = new Four();
        System.out.println(four.calculate(" 2-1"));
        four = new Four();
        System.out.println(four.calculate("(1-(4-5+2)-3)-(6+8)"));
    }
}
