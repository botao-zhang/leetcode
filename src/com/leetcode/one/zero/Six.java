package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class Six {
    int nodes = 0;
    private TreeNode build(int[] inorder, int from,int to, int[] post){
        if(from > to || nodes == post.length) return null;
        TreeNode root = new TreeNode(post[post.length - 1 - nodes]);
        int pivotal = from;
        for(;pivotal <= to;pivotal++) if(inorder[pivotal] == root.val) break;
        nodes++;

        root.right = build(inorder,pivotal + 1,to,post);
        root.left = build(inorder,from,pivotal - 1,post);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length - 1,postorder);
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.buildTree(new int[]{2,1,3},new int[]{2,3,1}));
    }
}
