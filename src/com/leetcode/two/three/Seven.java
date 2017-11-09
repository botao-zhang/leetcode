package com.leetcode.two.three;

import com.leetcode.util.ListNode;

public class Seven {
    public void deleteNode(ListNode node) {
        if(node == null) return;
        ListNode prev = node,cur = node.next;
        while (cur.next != null){
            prev.val = cur.val;
            prev = cur;
            cur = cur.next;
        }
        prev.val = cur.val;
        prev.next = null;
    }
}
