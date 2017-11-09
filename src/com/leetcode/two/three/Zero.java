package com.leetcode.two.three;

import com.leetcode.util.TreeNode;

public class Zero {
    int cnt = 0;


    private Integer visit(TreeNode root,int k){
        if(root == null) return null;
        Integer l = visit(root.left,k);
        if(l != null) return l;
        cnt++;
        if(cnt == k) return root.val;
        return visit(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        return visit(root,k);
    }
}
