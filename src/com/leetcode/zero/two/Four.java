package com.leetcode.zero.two;

import com.leetcode.util.ListNode;

public class Four {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head,ret = new ListNode(0),prev = ret;
        while (cur != null){
            if(cur.next == null){
                prev.next = cur;
                return ret.next;
            }

            ListNode next = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = null;
            prev = cur;
            cur = next;
        }
        return ret.next;
    }
}
