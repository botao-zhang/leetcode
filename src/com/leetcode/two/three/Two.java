package com.leetcode.two.three;

import java.util.Stack;

public class Two {
    class MyQueue {
        Stack<Integer> n = new Stack<>(),s = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!n.isEmpty()){
                s.push(n.pop());
            }
            s.push(x);
            while (!s.isEmpty()){
                n.push(s.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return n.pop();
        }

        /** Get the front element. */
        public int peek() {
            return n.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return n.isEmpty();
        }
    }
}
