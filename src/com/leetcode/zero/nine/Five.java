package com.leetcode.zero.nine;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Five {
    private List<TreeNode> genTree(int from,int to){
        List<TreeNode> nodes = new ArrayList<>();

        for(int i = from;i<=to;i++){

            List<TreeNode> lefts = genTree(from,i-1);
            List<TreeNode> rights = genTree(i+1,to);

            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    nodes.add(node);
                }
            }
        }

        if(nodes.isEmpty()) nodes.add(null);
        return nodes;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return Collections.EMPTY_LIST;
        return genTree(1,n);
    }

}
