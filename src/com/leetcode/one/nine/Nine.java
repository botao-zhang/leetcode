package com.leetcode.one.nine;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Nine {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();

        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);

        while (!levels.isEmpty()){
            ret.add(levels.peek().val);
            int len = levels.size();
            for(int i = 0;i<len;i++){
                TreeNode node = levels.remove();
                if(node.right != null) levels.add(node.right);
                if(node.left != null) levels.add(node.left);

            }
        }
        return ret;
    }
}
