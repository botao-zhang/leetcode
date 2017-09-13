package com.leetcode.zero.zero;

/**
 * Created by botao on 2017/9/13.
 */
public class Four {
    private double findKthSmallest(int[] nums1,int from1, int[] nums2, int from2, int k){
        if(from1 == nums1.length) return nums2[from2 + k - 1];
        if(from2 == nums2.length) return nums1[from1 + k - 1];
        if(k == 1) return Math.min(nums1[from1],nums2[from2]);

        int half1 = k / 2, half2 = k - half1;
        int n1 = Integer.MAX_VALUE,n2 = Integer.MAX_VALUE;
        if(half1 <= nums1.length - from1) n1 = nums1[from1 + half1 - 1];
        if(half2 <= nums2.length - from2) n2 = nums2[from2 + half2 - 1];

        if(n1 == n2) return n1;
        if(n1 < n2) return findKthSmallest(nums1,from1 + half1,nums2,from2,half2);
        else return findKthSmallest(nums1,from1,nums2,from2 + half2,half1);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int sumL = nums1.length + nums2.length;
        return (findKthSmallest(nums1,0, nums2, 0,(sumL + 1) / 2) +
                findKthSmallest(nums1,0, nums2, 0,(sumL + 2) / 2)) / 2;
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(four.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(four.findMedianSortedArrays(new int[]{1,2},new int[]{}));

    }
}
