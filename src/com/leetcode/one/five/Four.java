package com.leetcode.one.five;

public class Four {
    private int find(int[] nums,int from,int to){
        System.out.println("from = " + from + " to = " + to);
        if(from > to) return nums[0];
        int mid = (from + to) / 2;
        if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];

        if(nums[mid] > nums[0]) return find(nums,mid + 1,to);
        else if(nums[mid] == nums[0]) return Math.min(find(nums,mid + 1,to),find(nums,from,mid - 1));
        return find(nums,from,mid - 1);
    }
    public int findMin(int[] nums) {
        return find(nums,0,nums.length - 1);
    }

    public static void main(String[] args) {
        Four four = new Four();
        System.out.println(four.findMin(new int[]{2,1}));
        System.out.println(four.findMin(new int[]{1,2,3}));
        System.out.println(four.findMin(new int[]{2,3,1,2}));
    }
}
