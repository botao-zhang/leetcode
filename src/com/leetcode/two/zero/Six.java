package com.leetcode.two.zero;

import com.leetcode.util.ListNode;

public class Six {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null,cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
