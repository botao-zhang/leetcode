package com.leetcode.one.four;

import com.leetcode.util.ListNode;

public class Three {
    public void reorderList(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode fast = first,slow = first;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        first = first.next;
        ListNode second = prev;
        while (first != null && second != null){
            ListNode nextF = first.next,nextS = second.next;
            first.next = second;
            second.next = nextF;
            first = nextF;
            second = nextS;
        }
    }
}
