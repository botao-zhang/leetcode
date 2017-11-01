package com.leetcode.one.six;

import com.leetcode.util.ListNode;

public class Zero {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA,curB = headB;
        int l1 = 0,l2 = 0;
        while(curA != null){
            l1++;
            curA = curA.next;
        }

        while (curB != null){
            l2++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        for(int i = 0;i<l1 - l2;i++) curA = curA.next;
        for(int i = 0;i<l2 - l1;i++) curB = curB.next;

        while (curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
