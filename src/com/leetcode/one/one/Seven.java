package com.leetcode.one.one;

import com.leetcode.util.TreeLinkNode;

public class Seven {
    private void helper(TreeLinkNode cur,TreeLinkNode parent){
        if(cur == null) return;
        if(parent != null){
            if(cur == parent.left){
                if(parent.right != null){
                    cur.next = parent.right;
                }
            }
            TreeLinkNode pn = parent.next;
            while (cur.next == null && pn != null){
                if(pn.left != null) cur.next = pn.left;
                else cur.next = pn.right;

                pn = pn.next;
            }
        }

        helper(cur.right,cur);
        helper(cur.left,cur);
    }
    public void connect(TreeLinkNode root) {
        helper(root,null);
    }
}
