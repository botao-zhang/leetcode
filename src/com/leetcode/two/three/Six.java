package com.leetcode.two.three;

import com.leetcode.util.TreeNode;

import java.util.HashSet;

public class Six {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        if(l != null && r != null) return root;
        if(l == null) return r;
        return l;

    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(-1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(-2);
        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(8);
        Six six = new Six();
        System.out.println(six.lowestCommonAncestor(node,node.left.right,node.left.right.right));
    }
}
