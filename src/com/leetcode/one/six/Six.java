package com.leetcode.one.six;

import java.util.HashMap;

public class Six {
    private void appendFraction(long numerator, long denominator,StringBuilder str){
        HashMap<Long,Integer> recur = new HashMap<>();
        while (numerator != 0 && !recur.containsKey(numerator)){
            recur.put(numerator,str.length());
            numerator *= 10;
            long q = numerator / denominator;
            str.append(q);
            numerator = numerator % denominator;
        }

        if(numerator == 0) return;
        int last = recur.get(numerator);
        str.insert(last,'(');
        str.append(')');
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long pn = Math.abs((long) numerator),pd = Math.abs((long) denominator);

        long integer = pn / pd;
        StringBuilder stringBuilder = new StringBuilder();
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) stringBuilder.append('-');
        stringBuilder.append(integer);

        if(numerator % denominator == 0) return stringBuilder.toString();
        stringBuilder.append(".");

        appendFraction(pn % pd,pd,stringBuilder);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Six six = new Six();
        System.out.println(six.fractionToDecimal(2,3));
        System.out.println(six.fractionToDecimal(2,1));
        System.out.println(six.fractionToDecimal(1,2));
        System.out.println(six.fractionToDecimal(-50,8));
        System.out.println(six.fractionToDecimal(Integer.MIN_VALUE,3));
        System.out.println(six.fractionToDecimal(2,-3));

    }
}
