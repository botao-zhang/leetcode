package com.leetcode.three.eight;

import java.util.*;

public class Zero {
    static class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        HashMap<Integer,Integer> map = new HashMap<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;

            if(map.size() == list.size()){
                list.add(val);
            }else{
                list.set(map.size(),val);
            }
            map.put(val,map.size());

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            Integer idx = map.remove(val);
            if(idx == null) return false;

            if(idx != map.size()) {
                int last = list.get(map.size());
                list.set(idx, last);
                map.put(last, idx);
            }


            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(r.nextInt(map.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(0);
        randomizedSet.getRandom();
    }

}
