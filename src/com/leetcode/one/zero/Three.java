package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Three {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean fromLeft = true;
        while (!q.isEmpty()){
            int cnt = q.size();
            List<TreeNode> level = new ArrayList<>();
            for(int i = 0;i<cnt;i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                level.add(node);
            }
            List<Integer> num = new ArrayList<>();
            if(fromLeft) for(int i = 0;i<level.size();i++) num.add(level.get(i).val);
            else for(int i = level.size() - 1;i>=0;i--) num.add(level.get(i).val);
            ret.add(num);
            fromLeft = !fromLeft;
        }
        return ret;
    }
}
