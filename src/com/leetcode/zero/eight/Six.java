package com.leetcode.zero.eight;

import com.leetcode.util.ListNode;

public class Six {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0),sprev = smaller,larger = new ListNode(0),lprev = larger;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            if(cur.val < x){
                sprev.next = cur;
                sprev = cur;
            }else{
                lprev.next = cur;
                lprev = cur;
            }
            cur.next = null;
            cur = next;
        }

        sprev.next = larger.next;
        return smaller.next;
    }
}
