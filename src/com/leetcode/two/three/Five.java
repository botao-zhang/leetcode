package com.leetcode.two.three;

import com.leetcode.util.TreeNode;

public class Five {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        int min = Math.min(p.val,q.val),max = Math.max(p.val,q.val);
        while (cur != null){
            if(cur.val >= min && cur.val <= max) return cur;
            if(cur.val > max) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }
}
