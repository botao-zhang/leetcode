package com.leetcode.zero.nine;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Four {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.right != null){
                s.push(node.right);
                node.right = null;
            }
            if(node.left != null){
                s.push(node);
                s.push(node.left);
                node.left = null;
            }else{
                ret.add(node.val);
            }
        }
        return ret;
    }
}
