package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class One {
    private boolean help(TreeNode first,TreeNode second){
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;
        if(first.val != second.val) return false;

        return help(first.left,second.right) && help(first.right,second.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return help(root.left,root.right);
    }
}
