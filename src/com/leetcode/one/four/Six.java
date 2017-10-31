package com.leetcode.one.four;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Six {
    class LRUCache {
        private int cap = 0;
        Deque<int[]> q = new LinkedList<>();
        Map<Integer,int[]> map = new HashMap<>();

        public LRUCache(int capacity){
            this.cap = capacity;
        }

        public int get(int key){
            int[] value = map.get(key);
            if(value == null) return -1;

            q.remove(value);
            q.addFirst(value);

            return value[1];
        }

        public void put(int key, int value){
            int[] set = map.get(key);
            if(set == null){
                set = new int[]{key,value};
                if(map.size() == cap){
                    int[] last = q.removeLast();
                    map.remove(last[0]);
                }
                map.put(key,set);
            }else{
                q.remove(set);
                set[1] = value;
            }

            q.addFirst(set);
        }
    }

}
