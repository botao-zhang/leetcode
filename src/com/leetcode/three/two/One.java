package com.leetcode.three.two;

import java.util.Queue;

public class One {
    private String toString(int[] nums,int k, int len){
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<len;i++){
            s.append(nums[k + i]);
        }
        return s.toString();
    }

    private String[] pick(int[] nums,int k){
        String[][] ret = new String[k + 1][nums.length];
        for(int i = 0;i<nums.length;i++) ret[0][i] = "0";
        for(int i = 1;i<=k;i++){
            ret[i][nums.length - i] = toString(nums,nums.length - i,i);

            for(int j = nums.length - i - 1;j>=0;j--){
                if(nums[j] >= ret[i][j+1].charAt(0) - '0') ret[i][j] = new Integer(nums[j]).toString() + ret[i - 1][j + 1];
            }
        }

        String[] result = new String[k];
        for(int i = 0;i<k;i++){
            result[i] = ret[i + 1][0];
        }
        return result;
    }

    private String merge(String str1,String str2){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0,j = 0;
        while (i < str1.length() && j < str2.length()){
            if(str1.charAt(i) > str2.charAt(j)) stringBuilder.append(str1.charAt(i++));
            else if(str1.charAt(i) < str2.charAt(j)) stringBuilder.append(str2.charAt(j++));
            else {
                if ((str1.substring(i + 1) + str2).compareTo(str2.substring(j + 1) + str1) >= 0)
                    stringBuilder.append(str1.charAt(i++));
                else stringBuilder.append(str2.charAt(j++));
            }
        }
        return stringBuilder.toString();
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        int min1 = Math.max(0,k - nums2.length),min2 = Math.max(0,k - nums1.length);
        int max1 = Math.min(nums1.length,k),max2 = Math.min(nums2.length,k);

        String[] str1 = pick(nums1,max1), str2 = pick(nums2,max2);

        String max = "";
        for(int i = 0;i<max1;i++){
            String can = merge(str1[i],str2[k - 1 - i]);
            if(can.compareTo(max) > 0){
                max = can;
            }
        }
        int[] ret = new int[k];
        for(int i = 0;i<ret.length;i++) ret[i] = max.charAt(i) - '0';
        return ret;
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.maxNumber(new int[]{3, 4, 6, 5},new int[]{9, 1, 2, 5, 8, 3},5));
    }


}
