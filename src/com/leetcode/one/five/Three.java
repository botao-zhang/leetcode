package com.leetcode.one.five;

public class Three {
    private int find(int[] nums,int from,int to){
        System.out.println("from = " + from + " to = " + to);
        if(from > to) return nums[0];
        int mid = (from + to) / 2;
        if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];

        if(nums[mid] >= nums[0]) return find(nums,mid + 1,to);
        return find(nums,from,mid - 1);
    }
    public int findMin(int[] nums) {
        return find(nums,0,nums.length - 1);
    }

    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.findMin(new int[]{2,1}));
        System.out.println(three.findMin(new int[]{3,1,2}));
    }
}
