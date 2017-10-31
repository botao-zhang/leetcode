package com.leetcode.one.four;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Four {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()){
            TreeNode node = s.pop();
            ret.add(node.val);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return ret;
    }
}
