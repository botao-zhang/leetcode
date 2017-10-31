package com.leetcode.one.four;

import com.leetcode.util.ListNode;

public class One {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head,slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
