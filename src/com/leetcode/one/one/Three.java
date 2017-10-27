package com.leetcode.one.one;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Three {
    private void help(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ret){
        path.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0) ret.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if(root.left != null) help(root.left,sum,path,ret);
        if(root.right != null) help(root.right,sum,path,ret);

        path.remove(path.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return Collections.emptyList();
        List<List<Integer>> ret = new ArrayList<>();
        help(root,sum,new ArrayList<>(),ret);
        return ret;
    }
}
