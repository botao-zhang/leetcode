package com.leetcode.zero.nine;

import com.leetcode.util.TreeNode;

import java.util.Stack;

public class Eight {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        Integer larger = null;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.left != null){
                s.push(node);
                s.push(node.left);
                node.left = null;
            }else{
                if(larger != null && node.val <= larger) return false;
                larger = node.val;
                if(node.right != null) s.push(node.right);
            }
        }
        return true;
    }
}
