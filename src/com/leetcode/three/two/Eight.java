package com.leetcode.three.two;

import com.leetcode.util.ListNode;

public class Eight {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0),even = new ListNode(0),op = odd,ep = even, cur = head;

        int cnt = 1;
        while (cur != null){
            ListNode next = cur.next;
            if(cnt % 2 == 1){
                op.next = cur;
                op = cur;
            }else{
                ep.next = cur;
                ep = cur;
            }
            cur.next = null;
            cur = next;
            cnt++;
        }
        op.next = even.next;
        return odd.next;
    }
}
