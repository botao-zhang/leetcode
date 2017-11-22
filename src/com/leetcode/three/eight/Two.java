package com.leetcode.three.eight;

import com.leetcode.util.ListNode;

import java.util.Random;

public class Two {
    class Solution {
        ListNode head;
        Random r = new Random();
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode cur = head;
            int cnt = 0,chosed = -1;
            while (cur != null){
                if(r.nextInt(cnt + 1) == 0){
                    chosed = cur.val;
                }
                cur = cur.next;
                cnt++;
            }
            return chosed;
        }
    }
}
