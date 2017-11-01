package com.leetcode.one.five;

import java.util.Stack;

public class Five {
    class MinStack {
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> mins = new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if(nums.isEmpty()){
                mins.push(x);
            }else{
                int last = mins.peek();
                mins.push(Math.min(last,x));
            }
            nums.push(x);
        }

        public void pop() {
            nums.pop();
            mins.pop();
        }

        public int top() {
            return nums.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }
}
