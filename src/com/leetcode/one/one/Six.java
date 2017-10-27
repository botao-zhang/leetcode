package com.leetcode.one.one;

import com.leetcode.util.TreeLinkNode;

public class Six {
    private void helper(TreeLinkNode cur,TreeLinkNode parent){
        if(cur == null) return;
        if(parent != null){
            if(cur == parent.right){
                if(parent.next != null) cur.next = parent.next.left;
            }
            else cur.next = parent.right;
        }

        helper(cur.right,cur);
        helper(cur.left,cur);
    }
    public void connect(TreeLinkNode root) {
        helper(root,null);
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        Six six = new Six();
        six.connect(root);
        System.out.println(root);
    }
}
