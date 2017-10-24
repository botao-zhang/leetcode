package com.leetcode.zero.nine;

import com.leetcode.util.ListNode;

public class Two {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode ret = new ListNode(0),prev = ret,cur = ret;
        ret.next = head;

        for(int i = 0;i<m;i++){
            prev = cur;
            cur = cur.next;
        }

        ListNode rePrev = null,reTail = cur;
        for(int i = 0;i<=n - m;i++){
            ListNode next = cur.next;
            cur.next = rePrev;
            rePrev = cur;
            cur = next;
        }

        prev.next = rePrev;
        reTail.next = cur;
        return ret.next;
    }

    public static void main(String[] args) {
        Two two = new Two();
        ListNode head = ListNode.create(new int[]{1});

        System.out.println(two.reverseBetween(head,1,1));

        head = ListNode.create(new int[]{1,2,3,4,5});
        System.out.println(two.reverseBetween(head,2,4));
    }
}
