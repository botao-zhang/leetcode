package com.leetcode.three.three;

import com.leetcode.util.TreeNode;

import java.util.HashMap;

public class Seven {

    public int rob(TreeNode root) {
        if(root == null) return 0;

        int not = rob(root.left) + rob(root.right);
        int with = root.val;
        if(root.left != null) with += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) with += rob(root.right.left) + rob(root.right.right);
        return Math.max(not,with);
    }
}
