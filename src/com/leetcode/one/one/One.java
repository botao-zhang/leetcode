package com.leetcode.one.one;

import com.leetcode.util.TreeNode;

public class One {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int h = Integer.MAX_VALUE;
        if(root.left != null) h = 1 + minDepth(root.left);
        if(root.right != null) h = Math.min(h,1 + minDepth(root.right));
        return h;
    }
}
