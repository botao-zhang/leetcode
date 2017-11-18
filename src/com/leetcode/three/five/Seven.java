package com.leetcode.three.five;

public class Seven {
    public int countNumbersWithUniqueDigits(int n) {


        int cnt = 1, uniq = 1;
        for(int i = 1;i<=n;i++){
            uniq += 9 * cnt;
            cnt *= (9 - i + 1);
        }
        return uniq;
    }

    public static void main(String[] args) {
        Seven seven = new Seven();
        for(int i = 0;i<=3;i++)
        System.out.println(seven.countNumbersWithUniqueDigits(i));
    }
}

