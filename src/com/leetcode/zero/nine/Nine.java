package com.leetcode.zero.nine;

import com.leetcode.util.TreeNode;

import java.util.Stack;

public class Nine {
    TreeNode first = null,second = null, prev = null;

    private void preOrder(TreeNode cur){
        if(cur.left != null) preOrder(cur.left);

        if(prev != null && cur.val <= prev.val){
            if(first == null) first = prev;
            second = cur;
        }

        prev = cur;

        if(cur.right != null) preOrder(cur.right);
    }
    public void recoverTree(TreeNode root){
        preOrder(root);

        System.out.println("first = " + first + " sec = " + second);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        nine.recoverTree(root);
        System.out.println(root.val);
    }
}
