package com.leetcode.one.seven;

import com.leetcode.util.TreeNode;

import java.util.Stack;

public class Three {
    public class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        private void enStack(TreeNode root){
            if(root == null) return;
            stack.push(root);
            enStack(root.left);
        }

        private TreeNode deStack(){
            if(stack.isEmpty()) return null;
            TreeNode node = stack.pop();
            enStack(node.right);
            return node;
        }

        public BSTIterator(TreeNode root) {
            enStack(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = deStack();
            return node.val;
        }
    }
}
