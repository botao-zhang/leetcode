package com.leetcode.zero.eight;

import com.leetcode.util.ListNode;

public class Three {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode prev = head,cur = head.next;
        while (cur != null){
            while (cur != null && cur.val == prev.val){
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
}
