package com.leetcode.util;

/**
 * Created by botao on 2017/9/13.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int v){
        this.val = v;
    }

    public static ListNode create(int[] nums){
        ListNode ret = new ListNode(0),prev = ret;
        for(int num : nums){
            prev.next = new ListNode(num);
            prev = prev.next;
        }
        return ret.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
