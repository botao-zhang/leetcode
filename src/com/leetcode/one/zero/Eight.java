package com.leetcode.one.zero;

import com.leetcode.util.TreeNode;

public class Eight {
    private TreeNode help(int[] nums,int from,int to){
        if(from > to) return null;
        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums,from,mid - 1);
        root.right = help(nums,mid + 1,to);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length - 1);
    }
}
