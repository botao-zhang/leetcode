package com.leetcode.one.two;

import java.util.HashMap;

public class Eight {
    public int longestConsecutive(int[] nums){
        HashMap<Integer,Integer> needLeft = new HashMap<>(),needRight = new HashMap<>();
        int max = 0;
        for(int num : nums){
            Integer leftCnt = needLeft.remove(num),rightCnt = needRight.remove(num);
            if(leftCnt == null) leftCnt = 0;
            if(rightCnt == null) rightCnt = 0;
            int len = leftCnt + rightCnt + 1, left = num - leftCnt - 1, right = num + rightCnt + 1;
            max = Math.max(max,len);

            int existingLeft = needRight.getOrDefault(left,0),existingRight = needLeft.getOrDefault(right,0);
            if(existingLeft < len) needRight.put(left,len);
            if(existingRight < len) needLeft.put(right,len);
        }

        return max;
    }

    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(eight.longestConsecutive(new int[]{-6,8,-5,7,-9,-1,-7,-6,-9,-7,5,7,-1,-8,-8,-2,0}));
    }
}
