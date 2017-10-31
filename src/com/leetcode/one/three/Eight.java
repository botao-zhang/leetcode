package com.leetcode.one.three;

import com.leetcode.util.RandomListNode;

import java.util.HashMap;

public class Eight {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head, ret = new RandomListNode(0),prev = ret;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while (cur != null){
            RandomListNode copied = new RandomListNode(cur.label);
            prev.next = copied;
            prev = copied;
            map.put(cur,copied);
            cur = cur.next;
        }

        cur = head;
        while (cur != null){
            RandomListNode copied = map.get(cur);
            copied.random = map.get(cur.random);
            cur = cur.next;
        }
        return ret.next;
    }
}
