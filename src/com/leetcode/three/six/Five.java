package com.leetcode.three.six;

import java.util.HashSet;

public class Five {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Five five = new Five();
        System.out.println(five.canMeasureWater(1,2,3));
        System.out.println(five.canMeasureWater(2,6,5));
        System.out.println(five.canMeasureWater(3,5,4));
    }

}
