package com.leetcode.zero.four;

public class Three {
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length() + 1];

        for(int i = num1.length() - 1;i>=0;i--){
            for(int j = num2.length() - 1;j>=0;j--){
                nums[num1.length() - 1 - i + (num2.length() - 1) - j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        StringBuilder s = new StringBuilder();
        int plus = 0;
        for(int i = 0;i<nums.length;i++){
            int sum = nums[i] % 10 + plus;
            if(i > 0) sum += nums[i - 1] / 10 % 10;
            if(i > 1) sum += nums[i - 2] / 100;
            s.insert(0,sum % 10);
            plus = sum / 10;
        }


        while (s.length() > 1 && s.charAt(0) == '0'){
            s.deleteCharAt(0);
        }

        return s.toString();
    }
}
