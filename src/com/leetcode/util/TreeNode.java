package com.leetcode.util;

public class TreeNode {
    public int val;
    public TreeNode left,right;
    public TreeNode(int v){val = v;}

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
