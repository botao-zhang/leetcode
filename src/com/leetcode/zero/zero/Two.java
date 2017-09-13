package com.leetcode.zero.zero;

import com.leetcode.util.ListNode;

/**
 * Created by botao on 2017/9/13.
 */
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1,cur2 = l2,ret = new ListNode(0),prev = ret;
        int carry = 0;
        while (cur1 != null || cur2 != null || carry > 0){
            int sum = (cur1 == null ? 0 : cur1.val) + (cur2 == null ? 0 : cur2.val) + carry;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            carry = sum / 10;
            if(cur1 != null) cur1 = cur1.next;
            if(cur2 != null) cur2 = cur2.next;
        }
        return ret.next;
    }
}
