package com.leetcode.one.two;

import com.leetcode.util.TreeNode;

public class Nine {
    int sum = 0;
    private void help(TreeNode cur,int existing){
        existing = existing * 10 + cur.val;
        if(cur.left == null && cur.right == null){
            sum += existing;
        }else{
            if(cur.left != null) help(cur.left,existing);
            if(cur.right != null) help(cur.right,existing);
        }
    }

    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        help(root,0);
        return sum;
    }
}
