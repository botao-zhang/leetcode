package com.leetcode.one.six;

public class Seven {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0,h = numbers.length - 1;
        while (l < h){
            int sum = numbers[l] + numbers[h];
            if(sum == target) return new int[]{l + 1,h + 1};
            if(sum > target) h--;
            else l++;
        }
        return new int[]{};
    }
}
