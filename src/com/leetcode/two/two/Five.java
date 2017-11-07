package com.leetcode.two.two;

import java.util.LinkedList;
import java.util.Queue;

public class Five {
    class MyStack {
        Queue<Integer> q = new LinkedList<>(),s = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            while (!q.isEmpty()){
                s.offer(q.poll());
            }

            q.offer(x);
            while (!s.isEmpty()){
                q.offer(s.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.remove();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
