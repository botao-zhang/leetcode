package com.leetcode.three.seven;

public class One {
    public int getSum(int a, int b) {
        int ret = 0, plus = 0;
        for(int i = 0;i<31;i++){
            int mask = 1 << i;
            int ia = (a & mask) > 0 ? 1 : 0, ib = (b & mask) > 0 ? 1 : 0;
            int sum = ia + ib + plus;
            if(sum % 2 != 0) ret |= mask;
            plus = sum / 2;
        }

        long min = Math.min(a,b),max = Math.max(a,b);
        if(max < 0 || Math.abs(min) > Math.abs(max)) ret |= 1 <<31;

        return ret;
    }

    public static void main(String[] args) {
        One one = new One();
        System.out.println(one.getSum(1,2));
        System.out.println(one.getSum(1,0));
        System.out.println(one.getSum(1,-1));
        System.out.println(one.getSum(1,-2));
        System.out.println(one.getSum(Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(one.getSum(Integer.MAX_VALUE,0));
    }
}
