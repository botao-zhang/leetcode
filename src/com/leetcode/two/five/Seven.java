package com.leetcode.two.five;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Seven {
    private void pre(TreeNode root,StringBuilder cur,List<String> ret){
        int l = cur.length();
        if(l > 0)cur.append("->");
        cur.append(root.val);

        if(root.left == null && root.right == null){
            ret.add(cur.toString());
        }else{
            if(root.left != null) pre(root.left,cur,ret);
            if(root.right != null) pre(root.right,cur,ret);
        }

        cur.delete(l,cur.length());
        return;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<String> ret = new ArrayList<>();
        pre(root,new StringBuilder(),ret);
        return ret;
    }
}
