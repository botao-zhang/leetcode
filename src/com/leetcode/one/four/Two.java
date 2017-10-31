package com.leetcode.one.four;

import com.leetcode.util.ListNode;

public class Two {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while (fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
