package com.leetcode.zero.one;

public class Two {
    public String intToRoman(int num) {
        String[] liters = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<num / nums[i];j++) ret.append(liters[i]);
            num -= num / nums[i] * nums[i];
        }
        return ret.toString();
    }
}
