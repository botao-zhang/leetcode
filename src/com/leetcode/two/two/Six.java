package com.leetcode.two.two;

import com.leetcode.util.TreeNode;

public class Six {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode left = invertTree(root.left),right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

}
