package com.leetcode.three.zero;

import java.util.LinkedList;
import java.util.Queue;

public class Seven {
    static class NumArray {
        private static class RangeNode{
            int from;
            int to;
            int val;
            RangeNode left;
            RangeNode right;

            RangeNode(int f,int t){
                this.from = f;
                this.to = t;
            }
        }

        private RangeNode build(int[] nums,int from,int to){
            if(from > to) return null;
            if(from == to){
                RangeNode node = new RangeNode(from,to);
                node.val = nums[from];
                return node;
            }

            RangeNode node = new RangeNode(from,to);
            int mid = (from + to) / 2;
            node.left = build(nums,from,mid);
            node.right = build(nums,mid + 1,to);

            node.val = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
            return node;
        }
        RangeNode root = null;
        int[] arr;
        public NumArray(int[] nums) {
            root = build(nums,0,nums.length - 1);
            this.arr = nums;
        }

        public void update(int i, int val) {
            RangeNode cur = root;
            int delta = val - arr[i];
            arr[i] = val;
            if(delta != 0) {
                while (cur != null) {
                    cur.val += delta;
                    int mid = (cur.from + cur.to) / 2;
                    if(i <= mid) cur = cur.left;
                    else cur = cur.right;
                }
            }
        }

        private int get(RangeNode cur,int i, int j){
            if(cur.from == i && cur.to == j) return cur.val;

            int mid = (cur.from + cur.to) / 2;
            if(mid >= j){
                return get(cur.left,i,j);
            }else if(mid < i){
                return get(cur.right,i,j);
            }else{
                return get(cur.left,i,mid) + get(cur.right,mid + 1,j);
            }
        }
        public int sumRange(int i, int j) {
            return get(root,i,j);
        }

    }

}
