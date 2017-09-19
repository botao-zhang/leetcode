package com.leetcode.zero.one;

public class Three {
    public int romanToInt(String s) {
        String[] liters = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int total = 0,curI = 0, curS = 0;
        while (curS < s.length()){
            if(s.startsWith(liters[curI],curS)){
                curS += liters[curI].length();
                total += nums[curI];
            }else{
                curI++;
            }
        }
        return total;
    }
}
