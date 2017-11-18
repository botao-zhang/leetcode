package com.leetcode.three.three;

public class Five {
    public boolean isSelfCrossing(int[] x){
        boolean trap = false;
        int limit = Integer.MAX_VALUE;
        for(int i = 0;i<x.length;i++){
            if(trap){
                if(x[i] >= limit) return true;
                limit = x[i - 1];
            }else{
                if(i > 1) {
                    if (x[i] <= x[i - 2]) {
                        trap = true;
                        limit = x[i - 1];
                        if(i >= 4 && x[i] + x[i - 4] >= x[i - 2]){
                            limit = x[i - 1] - x[i - 3];
                        }else if(i == 3 && x[i] == x[i - 2]){
                            limit = x[i - 1] - x[i - 3];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.isSelfCrossing(new int[]{2,1,1,2}));
        System.out.println(five.isSelfCrossing(new int[]{1,2,3,4}));
        System.out.println(five.isSelfCrossing(new int[]{1,1,1,1}));
        System.out.println(five.isSelfCrossing(new int[]{1,1,2,1,1}));
    }
}
