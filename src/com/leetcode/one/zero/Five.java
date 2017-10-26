package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class Five {
    int nodes = 0;
    private TreeNode build(int[] preorder, int[] inorder, int from, int to) {
        if(from > to) return null;
        TreeNode root = new TreeNode(preorder[nodes]);
        int pivotal = from;
        for(;pivotal <= to;pivotal++) if(inorder[pivotal] == root.val) break;
        nodes++;

        root.left = build(preorder,inorder,from,pivotal - 1);
        root.right = build(preorder,inorder,pivotal + 1,to);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length - 1);
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.buildTree(new int[]{1,2,3},new int[]{2,3,1}));
    }


}
