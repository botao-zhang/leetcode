package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class Four {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
