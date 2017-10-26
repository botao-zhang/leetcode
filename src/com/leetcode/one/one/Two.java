package com.leetcode.one.one;

import com.leetcode.util.TreeNode;

public class Two {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;

        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
}
