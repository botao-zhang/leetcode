package com.leetcode.one.four;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Five {
    public List<Integer> postorderTraversal(TreeNode root){
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        List<Integer> ret = new ArrayList<>();

        s.push(root);
        while (!s.isEmpty()){
            TreeNode node = s.pop();

            if(node.left == null && node.right == null){
                ret.add(node.val);
            }else {
                s.push(node);
                if (node.right != null) {
                    s.push(node.right);
                    node.right = null;
                }

                if (node.left != null) {
                    s.push(node.left);
                    node.left = null;
                }
            }
        }
        return ret;
    }
}
