package com.leetcode.one.four;

import com.leetcode.util.ListNode;

public class Seven {
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);

        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            ListNode prev = ret,iter = ret.next;
            while (iter != null && iter.val < cur.val){
                prev = iter;
                iter = iter.next;
            }
            prev.next = cur;
            cur.next = iter;
            cur = next;
        }
        return ret.next;
    }
}
