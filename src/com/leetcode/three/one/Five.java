package com.leetcode.three.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Five {
    private void mergeS(int[] array,int[] nums,int from,int to,List<Integer> ret){
        if(from == to) return;

        int mid = (from + to) / 2;
        mergeS(array,nums,from,mid,ret);
        mergeS(array,nums,mid+1,to,ret);
        int[] tmp = new int[to - from + 1];
        int i = from, j = mid + 1, k = 0;

        int shift = 0;
        while (k < tmp.length){
            if(i <= mid && j <= to) {
                if (nums[array[i]] <= nums[array[j]]){
                    ret.set(array[i],ret.get(array[i])+ shift);
                    tmp[k++] = array[i++];
                } else{
                    tmp[k++] = array[j++];
                    shift++;
                }
            }else if(i <= mid){
                ret.set(array[i],ret.get(array[i])+ shift);
                tmp[k++] = array[i++];
            }else{
                tmp[k++] = array[j++];
            }
        }

        System.arraycopy(tmp,0,array,from,tmp.length);
    }

    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        int[] array = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            array[i] = i;
        }

        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i<nums.length;i++) ret.add(0);
        mergeS(array,nums,0,array.length - 1,ret);

        return ret;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.countSmaller(new int[]{5, 2, 6, 1}));
    }
}
