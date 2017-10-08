package com.leetcode.zero.six;

public class Two {


    public int uniquePaths(int m, int n) {
        int a = Math.max(m,n);
        int b = Math.min(m,n);
        long sum = 1,total = a + b - 2;
        for(;total>=a;total--){
            sum *= total;
        }
        System.out.println("sum = " + sum);
        //for(int i = 1;i<=m - 1;i++) sum /= i;
        for(int i = 1;i< b;i++) sum /= i;

        return (int) sum;
    }

    public static void main(String[] args) {
        Two two = new Two();
        //System.out.println(two.uniquePaths(10,2));
        System.out.println(two.uniquePaths(1,2));
    }
}
