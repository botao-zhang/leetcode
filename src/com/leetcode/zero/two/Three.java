package com.leetcode.zero.two;

import com.leetcode.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Three {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for(ListNode node : lists) if(node != null) pq.add(node);
        ListNode ret = new ListNode(0),prev = ret;
        while (!pq.isEmpty()){
            ListNode min = pq.poll();
            prev.next = min;
            prev = min;
            if(min.next != null) pq.offer(min.next);
        }
        return ret.next;
    }
}
