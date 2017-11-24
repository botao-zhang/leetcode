package com.leetcode;

import com.leetcode.util.TreeNode;

public class Mock {
    int balanced(TreeNode root){
        if(root == null) return 0;

        int left = balanced(root.left), right = balanced(root.right);
        if(left < 0 || right < 0) return -1;
        if(Math.abs(left - right) > 1) return -1;

        return Math.max(left,right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return balanced(root) >= 0;
    }
}
