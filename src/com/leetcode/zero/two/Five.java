package com.leetcode.zero.two;

import com.leetcode.util.ListNode;

public class Five {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = new ListNode(0),prev = ret;
        ListNode fast = head,slow = head;

        while (fast != null){
            for(int i = 0;i<k - 1;i++){
                fast = fast.next;
                if(fast == null){
                    prev.next = slow;
                    return ret.next;
                }
            }
            fast = fast.next;
            ListNode segPrev = null,tmp = slow;
            while (slow != fast){
                ListNode next = slow.next;
                slow.next = segPrev;
                segPrev = slow;
                slow = next;
            }
            prev.next = segPrev;
            prev = tmp;
        }

        return ret.next;
    }
}
