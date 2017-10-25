package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class Zero {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
