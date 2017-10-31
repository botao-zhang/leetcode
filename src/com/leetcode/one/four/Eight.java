package com.leetcode.one.four;

import com.leetcode.util.ListNode;

public class Eight {
    private ListNode mergeSort(ListNode from,ListNode to){
        if(from.next == to){
            from.next = null;
            return from;
        }

        ListNode fast = from,slow = from;
        while (fast != to && fast.next != to){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = mergeSort(from,slow);
        ListNode second = mergeSort(slow,to);

        ListNode ret = new ListNode(0),prev = ret;
        while (first != null || second != null){
            if(second == null || (first != null && first.val < second.val)){
                prev.next = first;
                prev = first;
                first = first.next;
            }else{
                prev.next = second;
                prev = second;
                second = second.next;
            }
        }
        prev.next = null;
        return ret.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head,null);
    }
}
