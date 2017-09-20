package com.leetcode.zero.one;

import com.leetcode.util.ListNode;

public class Nine {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(1),fast = ret,slow = ret;
        ret.next = head;

        for(int i = 0;i<n;i++) fast = fast.next;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return ret.next;
    }
}
