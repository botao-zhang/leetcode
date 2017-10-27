package com.leetcode.one.one;

import com.leetcode.util.TreeNode;

public class Four {
    private TreeNode help(TreeNode cur,TreeNode prev){
        if(cur == null) return prev;
        if(prev != null) prev.right = cur;

        TreeNode left = cur.left, right = cur.right;
        cur.left = null;
        cur.right = null;
        TreeNode last = help(left,cur);
        last = help(right,last);
        return last;
    }

    public void flatten(TreeNode root) {
        help(root,null);
    }
}
