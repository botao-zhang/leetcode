package com.leetcode.zero.eight;

import com.leetcode.util.ListNode;

public class Two {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode ret = new ListNode(0),prev = ret,cur = head;
        ret.next = cur;
        int v = cur.val;
        while (cur != null){
            int cnt = 0;
            while (cur != null && cur.val == v){
                cnt++;
                cur = cur.next;
            }

            if(cnt > 1){
                prev.next = cur;
            }else{
                prev = prev.next;
            }

            if(cur != null) v = cur.val;

        }
        return ret.next;
    }

}
