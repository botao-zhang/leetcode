package com.leetcode.two.three;

import com.leetcode.util.ListNode;

public class Four {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode start = new ListNode(0),fast = start,slow = start;
        start.next = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rever = slow.next,prev = null;
        slow.next = null;

        while (rever != null){
            ListNode next = rever.next;
            rever.next = prev;
            prev = rever;
            rever = next;
        }

        fast = head;
        while (fast != null && prev != null){
            if(fast.val != prev.val) return false;
            fast = fast.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Four four = new Four();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(four.isPalindrome(head));
    }
}
