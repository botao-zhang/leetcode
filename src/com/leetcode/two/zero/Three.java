package com.leetcode.two.zero;

import com.leetcode.util.ListNode;

public class Three {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0),prev = ret,cur = head;

        while (cur != null){
            ListNode next = cur.next;
            if(cur.val != val){
                prev.next = cur;
                prev = cur;
                prev.next = null;
            }
            cur = next;
        }

        return ret.next;
    }
}
