package com.leetcode.one.two;

import com.leetcode.util.TreeNode;

import java.util.Arrays;

public class Four {
    int max = Integer.MIN_VALUE;

    private int help(TreeNode root){
        if(root == null) return -1;
        max = Math.max(max,root.val);
        int left = help(root.left);
        int right = help(root.right);

        int ret = Math.max(root.val,root.val + Math.max(left,right));
        max = Math.max(max,ret);

        if(ret > root.val){
            max = Math.max(max,root.val + left + right);
        }

        return ret;
    }

    public int maxPathSum(TreeNode root){
        if(root == null) return 0;
        help(root);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
        Four four = new Four();
        System.out.println(four.help(root));
    }
}
