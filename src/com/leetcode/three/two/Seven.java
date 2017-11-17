package com.leetcode.three.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Seven {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length];
        long last = 0;
        for(int i = 0;i<nums.length;i++){
            last += nums[i];
            sums[i] = last;
        }
        return mergeSort(sums,0,sums.length - 1,lower,upper);
    }

    private int mergeSort(long[] sums, int from, int to, int lower, int upper) {
        System.out.println("from = " + from + " to = " + to + " sums = " + Arrays.toString(sums));
        if(from > to) return 0;
        if(from == to) return sums[from] >= lower && sums[from] <= upper ? 1 : 0;
        int mid = (from + to) / 2;
        int cnt = mergeSort(sums,from,mid,lower,upper) + mergeSort(sums,mid + 1,to,lower,upper);

        int l = mid + 1,h = mid + 1;

        for(int i = from;i<=mid;i++){
            while (l <= to && sums[l] - sums[i] < lower) l++;
            while (h <= to && sums[h] - sums[i] <= upper) h++;
            cnt += h - l;
        }

        long[] tmp = new long[to - from + 1];

        int f = from, s = mid + 1;
        for(int i = 0;i<tmp.length;i++){

            if(f <= mid && s <= to) {
                if (sums[f] < sums[s]) {
                    tmp[i] = sums[f++];
                } else {
                    tmp[i] = sums[s++];
                }
            }else if(f <= mid){
                tmp[i] = sums[f++];
            }else{
                tmp[i] = sums[s++];
            }
            System.out.println(" i = " + i + " tmp = " + Arrays.toString(tmp));
        }
        System.arraycopy(tmp,0,sums,from,tmp.length);
        System.out.println("after call from = " + from + " to = " + to + " sums = " + Arrays.toString(sums) + " tmp = " + Arrays.toString(tmp));
        return cnt;
    }


    public static void main(String[] args) {
        Seven seven = new Seven();
//        System.out.println(seven.countRangeSum(new int[0],0,0));
//        System.out.println(seven.countRangeSum(new int[]{-1,1,2},0,0));
//       System.out.println(seven.countRangeSum(new int[]{-2,5,-1},-2,2));
//        System.out.println(seven.countRangeSum(new int[]{2147483647,-2147483648,-1,0},-1,0));
//        System.out.println(seven.countRangeSum(new int[]{-2,2,-2,-3,2,-2},-3,1));
//        System.out.println(seven.countRangeSum(new int[]{-2,2,-2,-3},-3,1));
        System.out.println(seven.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647},-564,3863));

    }
}
