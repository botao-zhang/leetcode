package com.leetcode.zero.six;

import com.leetcode.util.ListNode;

public class One {
    public ListNode rotateRight(ListNode head, int k) {

        int len = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            len++;
        }
        if(len == 0) return head;

        k = k % len;
        if(k == 0) return head;

        ListNode fast = head,slow = head;
        for(int i = 0;i<k;i++) fast = fast.next;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }
}
