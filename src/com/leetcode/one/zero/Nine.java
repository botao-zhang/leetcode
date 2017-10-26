package com.leetcode.one.zero;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;

public class Nine {
    private TreeNode help(ListNode from,ListNode to){
        if(from == to) return null;
        if(from.next == to) return new TreeNode(from.val);

        ListNode fast = from,slow = from;
        while (fast != to && fast.next != to){
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = help(from,slow);
        node.right = help(slow.next,to);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        return help(head,null);
    }

    public static void main(String[] args) {
        Nine nine = new Nine();
        ListNode head = ListNode.create(new int[]{-1,0,1,2});
        System.out.println(nine.sortedListToBST(head));
    }
}
