package com.leetcode.zero.two;

import com.leetcode.util.ListNode;

public class One {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0), prev = ret;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                prev = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            prev.next = l1;
            prev = l1;
            l1 = l1.next;
        }
        while (l2 != null){
            prev.next = l2;
            prev = l2;
            l2 = l2.next;
        }
        return ret.next;
    }
}
