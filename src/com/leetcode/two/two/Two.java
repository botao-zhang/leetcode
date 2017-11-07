package com.leetcode.two.two;

import com.leetcode.util.TreeNode;

public class Two {
    int getLH(TreeNode root){
        TreeNode cur = root;
        int lh = 0;
        while (cur != null){
            lh++;
            cur = cur.left;
        }
        return lh;
    }

    int getRH(TreeNode root){
        TreeNode cur = root;
        int rh = 0;
        while (cur != null){
            rh++;
            cur = cur.right;
        }
        return rh;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode cur = root;
        int lh = getLH(root);

        return countNodes(root,lh);
    }

    private int countNodes(TreeNode root,int h) {
        System.out.println("root = " + root + " h = " + h);
        int rh = getRH(root);
        if(rh == h) return (1 << h) - 1;

        int lrh = getRH(root.left);
        if(lrh == h - 1){
            return (1 << lrh) + countNodes(root.right);
        }
        return (1 << (h - 2)) + countNodes(root.left,h - 1);
    }

    public static void main(String[] args) {
        Two two = new Two();
        TreeNode root = new TreeNode(1);
        System.out.println(two.countNodes(root));
        root.left = new TreeNode(2);
        System.out.println(two.countNodes(root));
        root.right = new TreeNode(3);
        System.out.println(two.countNodes(root));
        root.left.left = new TreeNode(4);
        System.out.println(two.countNodes(root));
    }
}
