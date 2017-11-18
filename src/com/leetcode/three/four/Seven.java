package com.leetcode.three.four;

import java.util.*;

public class Seven {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashSet<Integer>[] arr = new HashSet[nums.length + 1];
        for(int i = 0;i<arr.length;i++) arr[i] = new HashSet<>();
        HashMap<Integer,Integer> cnt = new HashMap<>();

        for(int num : nums){
            int freq = cnt.getOrDefault(num,0);
            arr[freq].remove(num);
            arr[freq + 1].add(num);
            cnt.put(num,freq + 1);
            System.out.println("num = " + num + " arr = " + Arrays.toString(arr));
        }

        System.out.println("arr = " + Arrays.toString(arr));
        List<Integer> ret = new ArrayList<>();
        for(int i = nums.length;i>0;i--){
            ret.addAll(arr[i]);
            System.out.println("i = " + i + " ret = " + ret);
            if(ret.size() >= k) return ret;
        }
        return null;
    }

    public static void main(String[] args) {
        Seven seven = new Seven();
        System.out.println(seven.topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}
