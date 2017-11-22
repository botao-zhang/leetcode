package com.leetcode.three.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class One {
    static class RandomizedCollection {
        List<Integer> nums = new ArrayList<>();
        int cnt = 0;
        Random r = new Random();
        HashMap<Integer,List<Integer>> idxMap = new HashMap<>();
        List<Integer> subIdx = new ArrayList<>();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            List<Integer> list = idxMap.get(val);
            boolean ret = false;
            if(list == null) {
                ret = true;
                list = new ArrayList<>();
                idxMap.put(val, list);
            }

            if(cnt == nums.size()){
                nums.add(val);
                subIdx.add(list.size());
            }else{
                nums.set(cnt,val);
                subIdx.set(cnt,list.size());
            }
            list.add(cnt);
            cnt++;
            return ret;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            List<Integer> list = idxMap.get(val);
            if(list == null) return false;

            int id = list.remove(list.size() - 1);
            if(list.isEmpty()) idxMap.remove(val);
            if(id != cnt -1){
                int moved = nums.get(cnt - 1),subid = subIdx.get(cnt - 1);
                nums.set(id,moved);
                subIdx.set(id,subid);
                idxMap.get(moved).set(subid,id);
            }

            cnt--;

            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get(r.nextInt(cnt));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(1);
        r.insert(1);
        r.insert(2);
        System.out.println(r.getRandom());
        r.remove(1);
        System.out.println(r.getRandom());
        r.remove(2);
        System.out.println(r.getRandom());
    }
}
