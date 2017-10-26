package com.leetcode.one.one;

import com.leetcode.util.TreeNode;

import java.util.HashMap;

public class Zero {
    HashMap<TreeNode,Integer> depth = new HashMap<>();
    private int depth(TreeNode node){
        if(node == null) return 0;
        if(depth.containsKey(node)) return depth.get(node);
        int d = 1 + Math.max(depth(node.left), depth(node.right));
        depth.put(node,d);

        return d;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
